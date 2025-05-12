package com.example.scheduleapp.controller;

import com.example.scheduleapp.dto.ScheduleCreateRequestDto;
import com.example.scheduleapp.dto.ScheduleGetRequestDto;
import com.example.scheduleapp.dto.ScheduleResponseDto;
import com.example.scheduleapp.service.ScheduleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo")
public class ScheduleController {

    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    /*생성*/
    @PostMapping()
    public ResponseEntity<ScheduleResponseDto> createSchedule(@RequestBody ScheduleCreateRequestDto requestDto) {
        return new ResponseEntity<>(scheduleService.saveSchedule(requestDto.getTodo(), requestDto.getCreateName(), requestDto.getPassword()), HttpStatus.CREATED);
    }

    /*조회*/
    @GetMapping()
    public ResponseEntity<List<ScheduleResponseDto>> getAllSchedules(@RequestBody ScheduleGetRequestDto requestDto) {
        return new ResponseEntity<>(scheduleService.getAllSchedules(requestDto.getCreateName(), requestDto.getUpdateDate()), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> getScheduleById(@PathVariable Long id) {
        return new ResponseEntity<>(scheduleService.getScheduleById(id), HttpStatus.OK);
    }

    /*todo: 테스트용 - 추후 요구사항에 맞게 수정해야함*/
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteScheduleById(@PathVariable Long id) {
        scheduleService.removeScheduleById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}