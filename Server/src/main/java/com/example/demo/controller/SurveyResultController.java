package com.example.demo.controller;

import com.example.demo.dto.common.ResponseDTO;
import com.example.demo.entitiy.SurveyResult;
import com.example.demo.service.SurveyResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/survey-result")
public class SurveyResultController {
    @Autowired
    SurveyResultService surveyResultService;

    @PostMapping
    public ResponseEntity<ResponseDTO<SurveyResult>> createSurveyResult(
            @RequestBody SurveyResult surveyResult
    ) {
        try {
            return ResponseEntity.ok(new ResponseDTO<>(surveyResultService
                    .createSurveyResult(surveyResult)));
        } catch (Exception e) {
            return ResponseEntity.ok(new ResponseDTO<>("Ошибка при создании записи"));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDTO<SurveyResult>> updateSurveyResult(
            @PathVariable Long id
    ) {
        try {
            return ResponseEntity.ok(new ResponseDTO<>(surveyResultService
                    .getSurveyResult(id)));
        } catch (Exception e) {
            return ResponseEntity.ok(new ResponseDTO<>("Ошибка при создании записи"));
        }
    }

    @GetMapping
    public ResponseEntity<ResponseDTO<List<SurveyResult>>> getAllSurveyResult() {
        try {
            return ResponseEntity.ok(new ResponseDTO<>(surveyResultService
                    .getAllSurveyResult()));
        } catch (Exception e) {
            return ResponseEntity.ok(new ResponseDTO<>("Ошибка при создании записи"));
        }
    }

    @PutMapping
    public ResponseEntity<ResponseDTO<SurveyResult>> updateSurveyResult(@RequestBody SurveyResult surveyResult) {
        try {
            return ResponseEntity.ok(new ResponseDTO<>(surveyResultService
                    .updateSurveyResult(surveyResult)));
        } catch (Exception e) {
            return ResponseEntity.ok(new ResponseDTO<>("Ошибка при создании записи"));
        }
    }
}
