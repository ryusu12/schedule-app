package com.example.scheduleapp.dto.response;

import com.example.scheduleapp.entity.Schedule;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class ScheduleResponseDto {
    private Long scheduleId;
    private Long userId;
    private String todo;
    private String createName;
    private String password;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;

    public ScheduleResponseDto(Long id, Schedule schedule) {
        this.scheduleId = id;
        this.userId = schedule.getUserId();
        this.todo = schedule.getTodo();
        this.createName = schedule.getCreateName();
        this.password = schedule.getPassword();
        this.createDate = schedule.getCreateDate();
        this.updateDate = schedule.getUpdateDate();
    }
}