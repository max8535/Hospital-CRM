package com.example.demo.dto.auth;

public class PatientAuthRegisterRequest extends AuthRegisterRequest {
    private Long healthInsuranceNumber;
    private int age;

    public Long getHealthInsuranceNumber() {
        return healthInsuranceNumber;
    }

    public void setHealthInsuranceNumber(Long healthInsuranceNumber) {
        this.healthInsuranceNumber = healthInsuranceNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
