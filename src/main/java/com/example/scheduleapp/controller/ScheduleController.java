package com.example.scheduleapp.controller;

import com.example.scheduleapp.dto.request.ScheduleDeleteRequestDto;
import com.example.scheduleapp.dto.request.SchedulePatchRequestDto;
import com.example.scheduleapp.dto.request.SchedulePostRequestDto;
import com.example.scheduleapp.dto.response.ScheduleResponseDto;
import com.example.scheduleapp.entity.User;
import com.example.scheduleapp.service.schedule.ScheduleService;
import com.example.scheduleapp.service.user.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/todo")
public class ScheduleController {

    private final ScheduleService scheduleService;
    private final UserService userService;

    public ScheduleController(
            ScheduleService scheduleService,
            UserService userService
    ) {
        this.scheduleService = scheduleService;
        this.userService = userService;
    }

    //생성
    @PostMapping()
    public ResponseEntity<ScheduleResponseDto> createSchedule(@Valid @RequestBody SchedulePostRequestDto requestDto) {
        //사용자를 생성한 뒤, 일정 생성
        User user = userService.saveUser(requestDto.getCreateName(), requestDto.getEmail());
        return new ResponseEntity<>(scheduleService.saveSchedule(requestDto.getTodo(), user, requestDto.getPassword()), HttpStatus.CREATED);
    }

    //조회
    @GetMapping()
    public ResponseEntity<List<ScheduleResponseDto>> getAllSchedules(
            @RequestParam(required = false) String createName,
            @RequestParam(required = false) Long userId,
            @RequestParam(required = false) Date updateDate,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return new ResponseEntity<>(scheduleService.getAllSchedules(createName, userId, updateDate, page, size), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> getScheduleById(@PathVariable Long id) {
        return new ResponseEntity<>(scheduleService.getScheduleById(id), HttpStatus.OK);
    }

    //수정
    @PatchMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> updateSchedule(
            @PathVariable Long id,
            @Valid @RequestBody SchedulePatchRequestDto requestDto
    ) {
        return new ResponseEntity<>(scheduleService.updateSchedule(id, requestDto.getTodo(), requestDto.getCreateName(), requestDto.getPassword()), HttpStatus.OK);
    }

    //삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSchedule(
            @PathVariable Long id,
            @Valid @RequestBody ScheduleDeleteRequestDto requestDto
    ) {
        scheduleService.removeSchedule(id, requestDto.getPassword());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}