package com.example.demo.entitiy;

import com.example.demo.utils.enums.SurveyScheduleStatusEnum;
import jakarta.persistence.*;

import java.util.Date;

@Entity
public class ScheduleSurvey {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private SurveyScheduleStatusEnum status = SurveyScheduleStatusEnum.PLANNED;
    private Date date;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SurveyScheduleStatusEnum getStatus() {
        return status;
    }

    public void setStatus(SurveyScheduleStatusEnum status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
