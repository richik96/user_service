package com.scaler.user_service_oct24.Dto;

import com.scaler.user_service_oct24.models.Role;
import com.scaler.user_service_oct24.models.User;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserDto {

    private String email;
    private String password;
    private String username;

    @ManyToMany
    private List<Role> roles;
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
