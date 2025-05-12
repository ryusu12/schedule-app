package com.example.scheduleapp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.sql.Date;
import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class Schedule {
    private Long scheduleId;
    private String todo;
    private String createName;
    private String password;
    private Date createDate;
    private Date updateDate;

    public Schedule(String todo, String createName, String password) {
        this.todo = todo;
        this.createName = createName;
        this.password = password;
        this.createDate = Date.valueOf(LocalDate.now());
        this.updateDate = Date.valueOf(LocalDate.now());
    }
}