package com.example.scheduleapp.controller;

import com.example.scheduleapp.dto.ScheduleDeleteRequestDto;
import com.example.scheduleapp.dto.SchedulePostAndPatchRequestDto;
import com.example.scheduleapp.dto.ScheduleResponseDto;
import com.example.scheduleapp.service.ScheduleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/todo")
public class ScheduleController {

    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    //생성
    @PostMapping()
    public ResponseEntity<ScheduleResponseDto> createSchedule(@RequestBody SchedulePostAndPatchRequestDto requestDto) {
        return new ResponseEntity<>(scheduleService.saveSchedule(requestDto.getTodo(), requestDto.getCreateName(), requestDto.getPassword()), HttpStatus.CREATED);
    }

    //조회
    @GetMapping()
    public ResponseEntity<List<ScheduleResponseDto>> getAllSchedules(
            @RequestParam(required = false) String createName,
            @RequestParam(required = false) Date updateDate
    ) {
        return new ResponseEntity<>(scheduleService.getAllSchedules(createName, updateDate), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> getScheduleById(@PathVariable Long id) {
        return new ResponseEntity<>(scheduleService.getScheduleById(id), HttpStatus.OK);
    }

    //수정
    @PatchMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> updateSchedule(
            @PathVariable Long id,
            @RequestBody SchedulePostAndPatchRequestDto requestDto
    ) {
        return new ResponseEntity<>(scheduleService.updateSchedule(id, requestDto.getTodo(), requestDto.getCreateName(), requestDto.getPassword()), HttpStatus.OK);
    }

    //삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSchedule(
            @PathVariable Long id,
            @RequestBody ScheduleDeleteRequestDto requestDto
    ) {
        scheduleService.removeSchedule(id, requestDto.getPassword());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}