package com.example.demo.service;

import com.example.demo.entitiy.ScheduleSurvey;
import com.example.demo.entitiy.SurveyResult;
import com.example.demo.repo.SurveyResultRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SurveyResultService {
    @Autowired
    SurveyResultRepo surveyResultRepo;

    public SurveyResult createSurveyResult(SurveyResult scheduleSurvey) {
        return surveyResultRepo.save(scheduleSurvey);
    }

    public SurveyResult updateSurveyResult(SurveyResult scheduleSurvey) {
        return surveyResultRepo.save(scheduleSurvey);
    }

    public SurveyResult getSurveyResult(Long id) {
        return surveyResultRepo.findById(id).orElseThrow();
    }

    public List<SurveyResult> getAllSurveyResult() {
        return (List<SurveyResult>) surveyResultRepo.findAll();
    }
}
