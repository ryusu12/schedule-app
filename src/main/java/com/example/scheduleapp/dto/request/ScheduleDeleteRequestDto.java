package com.example.scheduleapp.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class ScheduleDeleteRequestDto {
    @NotBlank
    private String password;
}