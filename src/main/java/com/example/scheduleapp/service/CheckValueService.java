package com.example.scheduleapp.service;

import com.example.scheduleapp.dto.SchedulePostRequestDto;
import com.example.scheduleapp.exception.InvalidRequestValuesException;
import org.springframework.stereotype.Service;

@Service
public class CheckValueService {
    public void checkPostRequestIsNull(SchedulePostRequestDto dto) {
        checkValueIsNull(dto.getCreateName(), "name");
        checkValueIsNull(dto.getEmail(), "email");
        checkValueIsNull(dto.getTodo(), "todo");
        checkValueIsNull(dto.getPassword(), "password");
    }

    public void checkPasswordIsNull(String password) {
        checkValueIsNull(password, "password");
    }

    public <T> void checkValueIsNull(T value, String fieldName) {
        if (value == null) {
            throw new InvalidRequestValuesException(fieldName + " is required value.");
        }
    }
}