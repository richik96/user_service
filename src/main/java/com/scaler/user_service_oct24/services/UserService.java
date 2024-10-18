package com.scaler.user_service_oct24.services;


import com.scaler.user_service_oct24.Exceptions.UserNotExistException;
import com.scaler.user_service_oct24.models.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    public User createUser(User user);
    public User updateUser(Long id, User user) throws UserNotExistException;
    public String deleteUser(Long id) throws UserNotExistException;
    public User getSingleUser(Long id) throws UserNotExistException;
    public List<User> getAllUsers();
}
