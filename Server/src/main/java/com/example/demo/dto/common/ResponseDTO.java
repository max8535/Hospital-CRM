package com.example.demo.dto.common;

public class ResponseDTO<T> {
    private final T data;
    private final String error;

    public ResponseDTO(T data, String error) {
        this.data = data;
        this.error = error;
    }

    public ResponseDTO(T data) {
        this.data = data;
        this.error = null;
    }

    public ResponseDTO(String error) {
        this.data = null;
        this.error = error;
    }

    public T getData() {
        return data;
    }

    public String getError() {
        return error;
    }

    @Override
    public String toString() {
        return "ResponseDTO{" +
                "data=" + data +
                ", error='" + error + '\'' +
                '}';
    }
}
