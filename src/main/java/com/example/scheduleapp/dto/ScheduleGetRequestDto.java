package com.example.scheduleapp.dto;

import lombok.Getter;

import java.sql.Date;

@Getter
public class ScheduleGetRequestDto {
    private String createName;
    private Date updateDate;
}