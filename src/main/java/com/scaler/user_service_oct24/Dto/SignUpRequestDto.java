package com.scaler.user_service_oct24.Dto;

import lombok.Data;

@Data
public class SignUpRequestDto {

    private String username;
    private String email;
    private String password;
}
