package com.example.scheduleapp.dto;

import lombok.Getter;

@Getter
public class SchedulePostRequestDto {
    private String todo;
    private String createName;
    private String email;
    private String password;
}