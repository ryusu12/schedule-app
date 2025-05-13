package com.example.scheduleapp.exception;

public class NotFoundScheduleException extends RuntimeException {
    public NotFoundScheduleException(String message) {
        super(message);
    }
}