package com.scaler.user_service_oct24.controllers;


import com.scaler.user_service_oct24.Exceptions.UserNotExistException;
import com.scaler.user_service_oct24.models.User;
import com.scaler.user_service_oct24.services.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserServiceController {

    @Autowired
    private UserService userService;

    public UserServiceController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getSingleUser(@PathVariable("id")  Long id) throws UserNotExistException {
        ResponseEntity<User> user = ResponseEntity.ok(userService.getSingleUser(id));
        return user;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        ResponseEntity<List<User>> response = ResponseEntity.ok(userService.getAllUsers());
        return response;
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        ResponseEntity<User> response = ResponseEntity.status(HttpStatus.CREATED)
                                        .header("Check result ", "Created new User")
                                        .body(userService.createUser(user));
        return response;
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") Long id, @RequestBody User user) throws UserNotExistException {
        ResponseEntity<User> response = ResponseEntity.status(HttpStatus.RESET_CONTENT)
                                        .header("Check result ", "Updated User")
                                        .body(userService.updateUser(id, user));
        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long id) throws UserNotExistException {
        ResponseEntity<String> response = ResponseEntity.status(HttpStatus.OK)
                                        .header("Check result ", "Deleted User")
                                        .body(userService.deleteUser(id));
        return response;
    }
}
