package com.example.demo.exceptions.user;

public class NotFilledRequiredFieldsException extends Exception{
    public NotFilledRequiredFieldsException(String message) {
        super("Не заполнены обязательные поля" + message);
    }
}
