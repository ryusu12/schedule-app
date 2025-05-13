package com.example.scheduleapp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class User {
    @Setter
    private Long userId;
    private String name;
    private String email;
    private Date createDate;
    private Date updateDate;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
        this.createDate = Date.valueOf(LocalDate.now());
        this.updateDate = Date.valueOf(LocalDate.now());
    }
}