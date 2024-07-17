package com.example.demo.dto.auth;

public class DoctorAuthRegisterRequest extends AuthRegisterRequest {
    private String specification;
    private int cabinet;

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public int getCabinet() {
        return cabinet;
    }

    public void setCabinet(int cabinet) {
        this.cabinet = cabinet;
    }
}
