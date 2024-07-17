package com.example.demo.repo;

import com.example.demo.entitiy.Patient;
import org.springframework.data.repository.CrudRepository;

public interface PatientRepo extends CrudRepository<Patient, Long> {
    Patient getPatientByUserId(Long userId);
}
