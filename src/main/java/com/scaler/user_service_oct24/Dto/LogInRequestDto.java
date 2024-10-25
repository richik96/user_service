package com.scaler.user_service_oct24.Dto;


import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class LogInRequestDto {

    private String email;
    private String password;

    public LogInRequestDto(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
