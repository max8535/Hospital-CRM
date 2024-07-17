package com.example.demo.service;

import com.example.demo.entitiy.Doctor;
import com.example.demo.entitiy.Patient;
import com.example.demo.entitiy.ScheduleSurvey;
import com.example.demo.repo.DoctorRepo;
import com.example.demo.repo.PatientRepo;
import com.example.demo.repo.ScheduleSurveyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleSurveyService {
    @Autowired
    ScheduleSurveyRepo scheduleSurveyRepo;

    @Autowired
    PatientRepo patientRepo;

    @Autowired
    DoctorRepo doctorRepo;

    public ScheduleSurvey createScheduleSurvey(ScheduleSurvey scheduleSurvey) {
        return scheduleSurveyRepo.save(scheduleSurvey);
    }

    public ScheduleSurvey updateScheduleSurvey(ScheduleSurvey scheduleSurvey) {
        return scheduleSurveyRepo.save(scheduleSurvey);
    }

    public ScheduleSurvey getScheduleSurvey(Long id) {
        return scheduleSurveyRepo.findById(id).orElseThrow();
    }

    public List<ScheduleSurvey> getAllScheduleSurvey() {
        return (List<ScheduleSurvey>) scheduleSurveyRepo.findAll();
    }
}
