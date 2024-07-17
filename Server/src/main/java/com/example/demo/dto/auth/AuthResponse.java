package com.example.demo.dto.auth;

import com.example.demo.entitiy.User;

public class AuthResponse {
    private String token;

    private User user;

    public AuthResponse(String token, User userDTO) {
        this.token = token;
        this.user = userDTO;
    }

    public String getToken() {
        return token;
    }

    public User getUser() {
        return user;
    }
}