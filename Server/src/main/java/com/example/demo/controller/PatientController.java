package com.example.demo.controller;

import com.example.demo.dto.common.ResponseDTO;
import com.example.demo.entitiy.Patient;
import com.example.demo.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/patients")
public class PatientController {
    @Autowired
    private PatientService patientService;

    @PostMapping
    public ResponseEntity<Patient> createPatient(@RequestBody Patient patient) {
        return ResponseEntity.ok(patientService.createPatient(patient));
    }

    @GetMapping("/by-user-id/{userId}")
    public ResponseEntity<ResponseDTO<Patient>> getPatientByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(new ResponseDTO(patientService.getPatientByUserId(userId)));
    }
}
