package com.example.scheduleapp.service.schedule;

import com.example.scheduleapp.dto.response.ScheduleResponseDto;
import com.example.scheduleapp.entity.Schedule;
import com.example.scheduleapp.entity.User;
import com.example.scheduleapp.exception.NotFoundScheduleException;
import com.example.scheduleapp.repository.schedule.ScheduleRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    private final ScheduleRepository scheduleRepository;

    public ScheduleServiceImpl(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    //생성
    @Override
    public ScheduleResponseDto saveSchedule(String todo, User user, String password) {
        Schedule schedule = new Schedule(todo, user, password);
        return scheduleRepository.saveSchedule(schedule);
    }

    //조회
    @Override
    public List<ScheduleResponseDto> getAllSchedules(String name, Long userId, Date updateDate, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return scheduleRepository.findAllSchedules(name, userId, updateDate, pageable);
    }

    @Override
    public ScheduleResponseDto getScheduleById(Long id) {
        return scheduleRepository.findScheduleByIdOrElseThrow(id);
    }

    //수정
    @Transactional
    @Override
    public ScheduleResponseDto updateSchedule(Long id, String todo, String name, String password) {
        int updatedRow = scheduleRepository.updateMemoTitle(id, todo, name, password);
        if (updatedRow == 0) {
            throw new NotFoundScheduleException("Does not exist schedule");
        }
        return scheduleRepository.findScheduleByIdOrElseThrow(id);
    }

    //삭제
    @Override
    public void removeSchedule(Long id, String password) {
        int deleteRow = scheduleRepository.removeSchedule(id, password);
        if (deleteRow == 0) {
            throw new NotFoundScheduleException("Does not exist schedule");
        }
    }
}