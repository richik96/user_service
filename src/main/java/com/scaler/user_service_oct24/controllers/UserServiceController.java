package com.scaler.user_service_oct24.controllers;


import com.scaler.user_service_oct24.Exceptions.UserNotExistException;
import com.scaler.user_service_oct24.models.User;
import com.scaler.user_service_oct24.services.UserService;
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
        ResponseEntity<User> user = new ResponseEntity<>(userService.getSingleUser(id), "GOOD", 200);
        return user;
    }

    @GetMapping
    public ResponseEntity<User> getAllUsers(){
        ResponseEntity<User> response = new ResponseEntity<>(userService.getAllUsers(), "GOOD", 200);
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
    public ResponseEntity<User> updateUser(@PathVariable("id") Long id, @RequestBody User user){
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long id){
        return userService.deleteUser(id);
    }
}
