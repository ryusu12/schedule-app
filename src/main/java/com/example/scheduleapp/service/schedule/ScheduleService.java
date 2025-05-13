package com.example.scheduleapp.service.schedule;

import com.example.scheduleapp.dto.response.ScheduleResponseDto;
import com.example.scheduleapp.entity.User;

import java.util.Date;
import java.util.List;

public interface ScheduleService {

    //생성
    ScheduleResponseDto saveSchedule(String todo, User user, String password);

    //조회
    List<ScheduleResponseDto> getAllSchedules(String name, Long userId, Date updateDate, int page, int size);

    ScheduleResponseDto getScheduleById(Long id);

    //수정
    ScheduleResponseDto updateSchedule(Long id, String todo, String name, String password);

    //삭제
    void removeSchedule(Long id, String password);
}