package com.scaler.user_service_oct24.Dto;


import lombok.Data;

@Data
public class LogInRequestDto {

    private String email;
    private String password;
}
