package com.example.demo.service;

import com.example.demo.entitiy.Doctor;
import com.example.demo.entitiy.User;
import com.example.demo.repo.DoctorRepo;
import com.example.demo.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepo doctorRepo;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private UserService userService;

    public Doctor createDoctor(Doctor doctor) {
        User user = userRepo.findById(doctor.getUser().getId()).orElse(null);
        if (user == null) {
            // throw
        }

        doctor.setUser(user);
        return doctorRepo.save(doctor);
    }

    public List<Doctor> getAll() {
        return (List<Doctor>) doctorRepo.findAll();
    }
}
