package com.scaler.user_service_oct24.services;


import com.scaler.user_service_oct24.Exceptions.UserNotExistException;
import com.scaler.user_service_oct24.models.User;
import com.scaler.user_service_oct24.repositories.AddressRepo;
import com.scaler.user_service_oct24.repositories.GeolocationRepo;
import com.scaler.user_service_oct24.repositories.UserRepo;
import com.scaler.user_service_oct24.repositories.User_NameRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service("MySqlDBService")
@Primary
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepo userRepo;
    private User_NameRepo nameRepo;
    private GeolocationRepo geolocaiton;
    private AddressRepo addressRepo;

    public UserServiceImpl(UserRepo userRepo, User_NameRepo nameRepo, GeolocationRepo geolocaiton, AddressRepo addressRepo) {
        this.userRepo = userRepo;
        this.nameRepo = nameRepo;
        this.geolocaiton = geolocaiton;
        this.addressRepo = addressRepo;
    }
    @Override
    public User createUser(User user){

        return  null;

    }

    @Override
    public User updateUser(Long id, User user){
        return null;
    }

    @Override
    public String deleteUser(Long id){
        return null;
    }

    @Override
    public User getSingleUser(Long id) throws UserNotExistException {

        Optional<User> user = userRepo.findById(id);
        if(user.isEmpty()) {
            throw new UserNotExistException("User ID- " + id + "does not exist");
        }
        return user.get();
    }

    @Override
    public List<User> getAllUsers(){

        return null;
    }
}
