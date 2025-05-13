package com.example.scheduleapp.repository.user;

import com.example.scheduleapp.entity.User;

public interface UserRepository {
    //생성
    User saveUser(User user);
}