package com.example.scheduleapp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class Schedule {
    private Long scheduleId;
    private Long userId;
    private String todo;
    private String createName;
    private String password;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;

    public Schedule(String todo, User user, String password) {
        this.todo = todo;
        this.userId = user.getUserId();
        this.createName = user.getName();
        this.password = password;
        this.createDate = LocalDateTime.now();
        this.updateDate = LocalDateTime.now();
    }
}