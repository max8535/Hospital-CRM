package com.example.demo.dto.auth;

public class AuthRegisterRequest extends AuthLoginRequest{
    private String repeatedPassword;
    private String firstName;
    private String lastName;

    public String getRepeatedPassword() {
        return repeatedPassword;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
