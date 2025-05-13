package com.example.scheduleapp.service.user;

import com.example.scheduleapp.entity.User;

public interface UserService {
    //생성
    User saveUser(String name, String email);
}