package com.example.scheduleapp.repository;

import com.example.scheduleapp.dto.ScheduleResponseDto;
import com.example.scheduleapp.entity.Schedule;

import java.util.Date;
import java.util.List;

public interface ScheduleRepository {

    /*생성*/
    ScheduleResponseDto saveSchedule(Schedule schedule);

    /*조회*/
    List<ScheduleResponseDto> findAllSchedules(String name, Date updateDate);

    ScheduleResponseDto findScheduleByIdOrElseThrow(Long id);

    /*수정*/
    int updateMemoTitle(Long id, String todo, String name, String password);

    /*삭제*/
    int removeSchedule(Long id, String password);
}