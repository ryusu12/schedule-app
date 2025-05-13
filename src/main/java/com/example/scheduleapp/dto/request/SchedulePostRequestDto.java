package com.example.scheduleapp.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class SchedulePostRequestDto {
    @Size(max = 200)
    @NotBlank
    private String todo;

    @NotBlank
    private String createName;

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String password;
}