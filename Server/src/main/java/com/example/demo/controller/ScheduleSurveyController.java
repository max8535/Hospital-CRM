package com.example.demo.controller;

import com.example.demo.dto.common.ResponseDTO;
import com.example.demo.entitiy.ScheduleSurvey;
import com.example.demo.service.ScheduleSurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/schedule-survey")
public class ScheduleSurveyController {
    @Autowired
    ScheduleSurveyService scheduleSurveyService;

    @PostMapping
    public ResponseEntity<ResponseDTO<ScheduleSurvey>> createScheduleSurvey(
            @RequestBody ScheduleSurvey scheduleSurvey
    ) {
        try {
            return ResponseEntity.ok(new ResponseDTO<>(scheduleSurveyService
                    .createScheduleSurvey(scheduleSurvey)));
        } catch (Exception e) {
            return ResponseEntity.ok(new ResponseDTO<>("Ошибка при создании записи"));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDTO<ScheduleSurvey>> getScheduleSurvey(
            @PathVariable Long id
    ) {
        try {
            return ResponseEntity.ok(new ResponseDTO<>(scheduleSurveyService
                    .getScheduleSurvey(id)));
        } catch (Exception e) {
            return ResponseEntity.ok(new ResponseDTO<>("Ошибка при создании записи"));
        }
    }

    @GetMapping
    public ResponseEntity<ResponseDTO<List<ScheduleSurvey>>> getAllScheduleSurvey() {
        try {
            return ResponseEntity.ok(new ResponseDTO<>(scheduleSurveyService
                    .getAllScheduleSurvey()));
        } catch (Exception e) {
            return ResponseEntity.ok(new ResponseDTO<>("Ошибка при создании записи"));
        }
    }

    @PutMapping
    public ResponseEntity<ResponseDTO<ScheduleSurvey>> updateScheduleSurvey(@RequestBody ScheduleSurvey scheduleSurvey) {
        try {
            return ResponseEntity.ok(new ResponseDTO<>(scheduleSurveyService
                    .updateScheduleSurvey(scheduleSurvey)));
        } catch (Exception e) {
            return ResponseEntity.ok(new ResponseDTO<>("Ошибка при обновлении записи"));
        }
    }
}
