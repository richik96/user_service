package com.scaler.user_service_oct24.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {

    private String email;
    private String password;
    private String phone;
    private String username;
    private NameDto name;
    private AddressDto address;
}
