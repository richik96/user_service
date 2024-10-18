package com.scaler.user_service_oct24.services;

import com.scaler.user_service_oct24.Exceptions.UserNotExistException;
import com.scaler.user_service_oct24.models.Address;
import com.scaler.user_service_oct24.models.Name;
import com.scaler.user_service_oct24.models.User;
import com.scaler.user_service_oct24.repositories.AddressRepo;
import com.scaler.user_service_oct24.repositories.UserRepo;
import com.scaler.user_service_oct24.repositories.User_NameRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service("MySqlDBService")
@Primary
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private User_NameRepo nameRepo;
    @Autowired
    private AddressRepo addressRepo;

    public UserServiceImpl(UserRepo userRepo, User_NameRepo nameRepo, AddressRepo addressRepo) {
        this.userRepo = userRepo;
        this.nameRepo = nameRepo;
        this.addressRepo = addressRepo;
    }
    @Override
    public User createUser(User user){

        Name name = user.getName();
        Address address = user.getAddress();
        if(name != null) {
            name.setUser(user);
        }
        if(address != null) {
            address.setUser(user);
        }
        return userRepo.save(user);
    }

    @Override
    public User updateUser(Long id, User user) throws UserNotExistException {

            Optional<User> user1 = userRepo.findById(id);
            if(user1.isEmpty()) {
                throw new UserNotExistException("User ID- " + id + "does not exist");
            }
            Name name = user.getName();
            Address address = user.getAddress();
            if(name != null) {
                Name savedName = nameRepo.save(name);
                user.setName(savedName);
            }
            if(address != null) {
                Address savedAddress = addressRepo.save(address);
                user.setAddress(savedAddress);
            }
            return userRepo.save(user);
    }

    @Override
    public String deleteUser(Long id) throws UserNotExistException{
        Optional<User> user = userRepo.findById(id);
        if(user.isEmpty()) {
            throw new UserNotExistException("User ID- " + id + "does not exist");
        }
        userRepo.deleteById(id);
        return "User ID- " + id + "deleted successfully";
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

        return userRepo.findAll();
    }
}
