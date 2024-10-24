package com.scaler.user_service_oct24.Dto;

import com.scaler.user_service_oct24.models.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {

    private String email;
    private String password;
    private String username;
   // private NameDto name;

    public static UserDto from(User user) {
        if(user == null) {
            return null;
        }
        UserDto userDto = new UserDto();
        userDto.setEmail(userDto.getEmail());
        userDto.setPassword(userDto.getPassword());
        userDto.setUsername(userDto.getUsername());
        return userDto;
    }

}
