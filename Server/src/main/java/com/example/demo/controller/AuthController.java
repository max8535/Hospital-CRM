package com.example.demo.controller;

import com.example.demo.dto.auth.*;
import com.example.demo.dto.common.ResponseDTO;
import com.example.demo.entitiy.Doctor;
import com.example.demo.entitiy.Patient;
import com.example.demo.entitiy.User;
import com.example.demo.exceptions.user.NotFilledRequiredFieldsException;
import com.example.demo.exceptions.user.UserAlreadyExistException;
import com.example.demo.exceptions.user.UserNotFoundException;
import com.example.demo.service.DoctorService;
import com.example.demo.service.PatientService;
import com.example.demo.service.UserService;
import com.example.demo.utils.JwtTokenUtils;
import com.example.demo.utils.enums.RoleEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private PatientService patientService;

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private JwtTokenUtils jwtTokenUtils;
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<ResponseDTO<AuthResponse>> login(@RequestBody AuthLoginRequest authLoginRequest) throws UserNotFoundException, UserNotFoundException {
        if (authLoginRequest.getPassword() == null || authLoginRequest.getLogin() == null) {
            return ResponseEntity.ok(new ResponseDTO<>("Не заполнены все поля"));
        }
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            authLoginRequest.getLogin(), authLoginRequest.getPassword()
                    )
            );
        } catch (BadCredentialsException e) {
            return ResponseEntity.ok(new ResponseDTO("Неправильный логин или пароль"));
        }catch (Exception e) {
            return ResponseEntity.ok(new ResponseDTO(e.getMessage()));
        }

        UserDetails userDetails = userService.loadUserByUsername(authLoginRequest.getLogin());
        User user = userService.findByLogin(authLoginRequest.getLogin());
        User returnedUser = userService.getUserById(user.getId());
        String token = jwtTokenUtils.generateToken(userDetails);
        return ResponseEntity.ok(new ResponseDTO<>(new AuthResponse(token, returnedUser)));
    }

    @PostMapping("/signup")
    public ResponseEntity<ResponseDTO<Patient>> signup(@RequestBody PatientAuthRegisterRequest authRegisterRequest) throws UserAlreadyExistException, NotFilledRequiredFieldsException {
        try {
            if (authRegisterRequest.getPassword() == null
                    || authRegisterRequest.getRepeatedPassword() == null
                    || authRegisterRequest.getFirstName() == null
                    || authRegisterRequest.getLastName() == null
                    || authRegisterRequest.getLogin() == null
                    || authRegisterRequest.getAge() == 0
                    || authRegisterRequest.getHealthInsuranceNumber() == null
            ) {
                return ResponseEntity.ok(new ResponseDTO<>("Не заполнены все поля"));
            }
            if (!Objects.equals(authRegisterRequest.getPassword(), authRegisterRequest.getRepeatedPassword())) {
                return ResponseEntity.ok(new ResponseDTO<>("Пароли не совпадают"));
            }
            User user = new User();
            user.setPassword(passwordEncoder.encode(authRegisterRequest.getPassword()));
            user.setLogin(authRegisterRequest.getLogin());
            user.setFirstName(authRegisterRequest.getFirstName());
            user.setLastName(authRegisterRequest.getLastName());
            User createdUser = userService.createUser(user, RoleEnum.PATIENT);

            Patient patient = new Patient();
            patient.setAge(authRegisterRequest.getAge());
            patient.setHealthInsuranceNumber(authRegisterRequest.getHealthInsuranceNumber());
            patient.setUser(createdUser);
            Patient createdPatient = patientService.createPatient(patient);
            return ResponseEntity.ok(new ResponseDTO<>(createdPatient));
        } catch (Exception e) {
            return ResponseEntity.ok(new ResponseDTO<>(e.getMessage()));
        }
    }

    @PostMapping("/signup/doctor")
    public ResponseEntity<ResponseDTO<Doctor>> signupDoctor(@RequestBody DoctorAuthRegisterRequest authRegisterRequest) throws UserAlreadyExistException, NotFilledRequiredFieldsException {
        try {
            if (authRegisterRequest.getPassword() == null
                    || authRegisterRequest.getRepeatedPassword() == null
                    || authRegisterRequest.getFirstName() == null
                    || authRegisterRequest.getLastName() == null
                    || authRegisterRequest.getLogin() == null
                    || authRegisterRequest.getCabinet() == 0
                    || authRegisterRequest.getSpecification() == null
            ) {
                return ResponseEntity.ok(new ResponseDTO<>("Не заполнены все поля"));
            }
            if (!Objects.equals(authRegisterRequest.getPassword(), authRegisterRequest.getRepeatedPassword())) {
                return ResponseEntity.ok(new ResponseDTO<>("Пароли не совпадают"));
            }
            User user = new User();
            user.setPassword(passwordEncoder.encode(authRegisterRequest.getPassword()));
            user.setLogin(authRegisterRequest.getLogin());
            user.setFirstName(authRegisterRequest.getFirstName());
            user.setLastName(authRegisterRequest.getLastName());
            User createdUser = userService.createUser(user, RoleEnum.DOCTOR);

            Doctor doctor = new Doctor();
            doctor.setUser(createdUser);
            doctor.setCabinet(authRegisterRequest.getCabinet());
            doctor.setSpecification(authRegisterRequest.getSpecification());
            Doctor createdDoctor = doctorService.createDoctor(doctor);
            return ResponseEntity.ok(new ResponseDTO<>(createdDoctor));
        } catch (Exception e) {
            return ResponseEntity.ok(new ResponseDTO<>(e.getMessage()));
        }
    }


    @GetMapping("/me")
    public ResponseEntity<ResponseDTO<?>> getMe() throws UserNotFoundException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findByLogin((String) authentication.getPrincipal());
        User getedUser = userService.getUserById(user.getId());
        String userLogin = (String) authentication.getPrincipal();

        UserDetails userDetails = userService.loadUserByUsername(userLogin);
        String token = jwtTokenUtils.generateToken(userDetails);
        return ResponseEntity.ok(new ResponseDTO<>(new AuthResponse(token, getedUser)));
    }

    @GetMapping("/logout")
    public ResponseEntity<ResponseDTO<?>> logout() {
        return ResponseEntity.ok(new ResponseDTO<>(new AuthResponse("LOGOUT_TOKEN", null)));
    }


}
