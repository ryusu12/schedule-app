package com.example.scheduleapp.dto.request;

import lombok.Getter;

import java.sql.Date;

@Getter
public class ScheduleGetRequestDto {
    private String createName;
    private Long userId;
    private Date updateDate;
    private int page = 0;
    private int size = 10;
}