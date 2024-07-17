package com.example.demo.exceptions.user;

public class UserAlreadyExistException extends Exception {
    public UserAlreadyExistException(String message) {
        super("Пользователь с таким " + message + " уже существует");
    }
}
