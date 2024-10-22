package com.scaler.user_service_oct24.services;


import com.scaler.user_service_oct24.Dto.UserDto;
import com.scaler.user_service_oct24.Exceptions.SignupFailureException;
import com.scaler.user_service_oct24.Exceptions.UserNotExistException;
import com.scaler.user_service_oct24.models.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    public User createUser(UserDto userDto);
    public User updateUser(Long id, UserDto userDto) throws UserNotExistException;
    public String deleteUser(Long id) throws UserNotExistException;
    public User getSingleUser(Long id) throws UserNotExistException;
    public List<User> getAllUsers();
    public User signup(UserDto userDto) throws SignupFailureException;
    public User login(UserDto userDto);
    public String logout(String token);
}
