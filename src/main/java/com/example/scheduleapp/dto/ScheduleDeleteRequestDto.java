package com.example.scheduleapp.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class ScheduleDeleteRequestDto {
    @NotBlank
    private String password;
}