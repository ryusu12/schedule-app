package com.example.scheduleapp.service;

import com.example.scheduleapp.dto.ScheduleResponseDto;

public interface ScheduleService {

    ScheduleResponseDto saveSchedule(String todo, String name, String password);

    void removeScheduleById(Long id);
}