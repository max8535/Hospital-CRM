package com.example.demo.service;

import com.example.demo.entitiy.Patient;
import com.example.demo.entitiy.User;
import com.example.demo.repo.PatientRepo;
import com.example.demo.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {
    @Autowired
    private PatientRepo patientRepo;

    @Autowired
    private UserRepo userRepo;

    public Patient createPatient(Patient patient) {
        User user = userRepo.findById(patient.getUser().getId()).orElse(null);
        if (user == null) {
            // throw
        }

        patient.setUser(user);
        return patientRepo.save(patient);
    }

    public Patient getPatientByUserId(Long userId) {
        return patientRepo.getPatientByUserId(userId);
    }
}
