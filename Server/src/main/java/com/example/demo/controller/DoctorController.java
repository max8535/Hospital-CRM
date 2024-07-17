package com.example.demo.controller;

import com.example.demo.dto.common.ResponseDTO;
import com.example.demo.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @GetMapping
    public ResponseEntity getAllDoctors() {
        return ResponseEntity.ok(new ResponseDTO<>(doctorService
                .getAll()));
    }

}
