package com.example.scheduleapp.service;

import com.example.scheduleapp.dto.ScheduleResponseDto;

import java.util.Date;
import java.util.List;

public interface ScheduleService {

    //생성
    ScheduleResponseDto saveSchedule(String todo, String name, String password);

    //조회
    List<ScheduleResponseDto> getAllSchedules(String name, Date updateDate);

    ScheduleResponseDto getScheduleById(Long id);

    //수정
    ScheduleResponseDto updateSchedule(Long id, String todo, String name, String password);

    //삭제
    void removeSchedule(Long id, String password);
}