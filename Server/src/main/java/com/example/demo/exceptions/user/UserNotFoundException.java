package com.example.demo.exceptions.user;

public class UserNotFoundException extends Exception {
    public UserNotFoundException(String message) {
        super("Пользователя с таким " + message + " не существует");
    }
}
