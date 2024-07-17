package com.example.demo.entitiy;

import jakarta.persistence.*;

@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long healthInsuranceNumber;
    private int medicalSiteNumber = 17;
    private int age;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Patient() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getHealthInsuranceNumber() {
        return healthInsuranceNumber;
    }

    public void setHealthInsuranceNumber(Long healthInsuranceNumber) {
        this.healthInsuranceNumber = healthInsuranceNumber;
    }

    public int getMedicalSiteNumber() {
        return medicalSiteNumber;
    }

    public void setMedicalSiteNumber(int medicalSiteNumber) {
        this.medicalSiteNumber = medicalSiteNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
