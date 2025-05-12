package com.example.scheduleapp.dto;

import com.example.scheduleapp.entity.Schedule;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.sql.Date;

@Getter
@AllArgsConstructor
public class ScheduleResponseDto {
    private Long scheduleId;
    private String todo;
    private String createName;
    private String password;
    private Date createDate;
    private Date updateDate;

    public ScheduleResponseDto(Long id, Schedule schedule) {
        this.scheduleId = id;
        this.todo = schedule.getTodo();
        this.createName = schedule.getCreateName();
        this.password = schedule.getPassword();
        this.createDate = schedule.getCreateDate();
        this.updateDate = schedule.getUpdateDate();
    }
}