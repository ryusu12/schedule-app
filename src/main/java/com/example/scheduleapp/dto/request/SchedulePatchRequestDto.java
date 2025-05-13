package com.example.scheduleapp.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class SchedulePatchRequestDto {
    @Size(max = 200)
    @NotBlank
    private String todo;

    private String createName;

    @NotBlank
    private String password;
}