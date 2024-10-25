package com.scaler.user_service_oct24.Dto;


import com.scaler.user_service_oct24.models.Token;
import lombok.Data;

@Data
public class LogOutRequestDto {

    private String token;
}
