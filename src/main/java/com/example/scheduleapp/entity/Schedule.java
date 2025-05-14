package com.example.scheduleapp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class Schedule {
    private Long scheduleId;
    private String todo;
    private String createName;
    private String password;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;

    public Schedule(String todo, String createName, String password) {
        this.todo = todo;
        this.createName = createName;
        this.password = password;
        this.createDate = LocalDateTime.now();
        this.updateDate = LocalDateTime.now();
    }
}