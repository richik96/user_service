package com.scaler.user_service_oct24.services;

import com.scaler.user_service_oct24.Dto.UserDto;
import com.scaler.user_service_oct24.Exceptions.SignupFailureException;
import com.scaler.user_service_oct24.Exceptions.UserNotExistException;
import com.scaler.user_service_oct24.models.Address;
import com.scaler.user_service_oct24.models.Geolocation;
import com.scaler.user_service_oct24.models.Name;
import com.scaler.user_service_oct24.models.User;
import com.scaler.user_service_oct24.repositories.AddressRepo;
import com.scaler.user_service_oct24.repositories.GeolocationRepo;
import com.scaler.user_service_oct24.repositories.UserRepo;
import com.scaler.user_service_oct24.repositories.User_NameRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service("MySqlDBService")
@Transactional
@Primary
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private User_NameRepo nameRepo;
    @Autowired
    private AddressRepo addressRepo;
    @Autowired
    private GeolocationRepo geoRepo;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    public UserServiceImpl(UserRepo userRepo, User_NameRepo nameRepo, AddressRepo addressRepo, GeolocationRepo geoRepo, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepo = userRepo;
        this.nameRepo = nameRepo;
        this.addressRepo = addressRepo;
        this.geoRepo = geoRepo;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
    @Override
    public User createUser(UserDto userDto){

        //convert DTO to user entity
        User user = new User();
        user.setEmail(userDto.getEmail());
        user.setHashedPassword(userDto.getPassword());
        user.setUsername(userDto.getUsername());

        //Set name
        Name name = new Name();
        name.setFirstName(userDto.getName().getFirstName());
        name.setLastName(userDto.getName().getLastName());
        Name savedName = nameRepo.save(name);
        user.setName(savedName);

        //Set address
        Address address = new Address();
        address.setCity(userDto.getAddress().getCity());
        address.setStreet(userDto.getAddress().getStreet());
        address.setZipcode(userDto.getAddress().getZipcode());
        address.setNumber(userDto.getAddress().getNumber());

        //Set geolocation
        Geolocation geolocation = new Geolocation();
        geolocation.setLatitude(userDto.getAddress().getGeolocation().getLat());
        geolocation.setLongitude(userDto.getAddress().getGeolocation().getLng());

        Geolocation savedGeo = geoRepo.save(geolocation);
        address.setGeoLocation(savedGeo);

        //Set address and geolocation in address
        Address savedAddress = addressRepo.save(address);
        user.setAddress(savedAddress);

        return userRepo.save(user);
    }

    @Override
    public User updateUser(Long id, UserDto userDto) throws UserNotExistException {

        return null;
//            Optional<User> user1 = userRepo.findById(id);
//            if(user1.isEmpty()) {
//                throw new UserNotExistException("User ID- " + id + "does not exist");
//            }
//            Name name = userDto.getName();
//            Address address = userDto.getAddress();
//            if(name != null) {
//                Name savedName = nameRepo.save(name);
//                userDto.setName(savedName);
//            }
//            if(address != null) {
//                Address savedAddress = addressRepo.save(address);
//                userDto.setAddress(savedAddress);
//            }
//            return userRepo.save(userDto);
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
        // Address address = user.get().getAddress();
        // if(address != null) {
        //     Geolocation geo = address.getGeoLocation();
        // }
        return user.get();
    }

    @Override
    public List<User> getAllUsers(){

        return userRepo.findAll();
    }

    @Override
    public User signup(UserDto userDto) throws SignupFailureException {
        User user = new User();
        if(userDto.getEmail() == null || userDto.getPassword() == null || userDto.getUsername() == null) {
            throw new SignupFailureException("Email, Password or Username cannot be null");
        }
        user.setEmail(userDto.getEmail());
        user.setHashedPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
        user.setUsername(userDto.getUsername());

        return userRepo.save(user);
    }

    @Override
    public User login(UserDto userDto) {
        return null;
    }

    @Override
    public String logout(String token) {
        return null;
    }
}
