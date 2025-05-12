package com.example.scheduleapp.service;

import com.example.scheduleapp.dto.ScheduleResponseDto;

import java.util.Date;
import java.util.List;

public interface ScheduleService {

    /*생성*/
    ScheduleResponseDto saveSchedule(String todo, String name, String password);

    /*조회*/
    List<ScheduleResponseDto> getAllSchedules(String name, Date updateDate);

    ScheduleResponseDto getScheduleById(Long id);

    /*삭제*/
    void removeScheduleById(Long id);
}