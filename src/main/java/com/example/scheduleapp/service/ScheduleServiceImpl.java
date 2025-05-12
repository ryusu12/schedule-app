package com.example.scheduleapp.service;

import com.example.scheduleapp.dto.ScheduleResponseDto;
import com.example.scheduleapp.entity.Schedule;
import com.example.scheduleapp.repository.ScheduleRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    private final ScheduleRepository scheduleRepository;

    public ScheduleServiceImpl(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    /*생성*/
    @Override
    public ScheduleResponseDto saveSchedule(String todo, String name, String password) {
        if (todo == null || name == null || password == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "todo, name, password are required values.");
        }
        Schedule schedule = new Schedule(todo, name, password);
        return scheduleRepository.saveSchedule(schedule);
    }

    /*조회*/
    @Override
    public List<ScheduleResponseDto> getAllSchedules(String name, Date updateDate) {
        return scheduleRepository.findAllSchedules(name, updateDate);
    }

    @Override
    public ScheduleResponseDto getScheduleById(Long id) {
        return scheduleRepository.findScheduleByIdOrElseThrow(id);
    }

    /*삭제*/
    @Override
    public void removeScheduleById(Long id) {
        int deleteRow = scheduleRepository.removeScheduleById(id);
        if (deleteRow == 0) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist schedule_id  = " + id);
        }
    }
}