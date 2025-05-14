package com.example.scheduleapp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class User {
    @Setter
    private Long userId;
    private String name;
    private String email;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
        this.createDate = LocalDateTime.now();
        this.updateDate = LocalDateTime.now();
    }
}