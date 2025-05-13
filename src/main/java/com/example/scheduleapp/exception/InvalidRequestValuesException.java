package com.example.scheduleapp.exception;

public class InvalidRequestValuesException extends RuntimeException {
    public InvalidRequestValuesException(String message) {
        super(message);
    }
}