package com.example.scheduleapp.dto;

import lombok.Getter;

@Getter
public class SchedulePostAndPatchRequestDto {
    private String todo;
    private String createName;
    private String password;
}