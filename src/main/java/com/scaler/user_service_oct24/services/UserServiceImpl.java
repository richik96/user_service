package com.scaler.user_service_oct24.services;

import com.scaler.user_service_oct24.Dto.LogInRequestDto;
import com.scaler.user_service_oct24.Dto.LogOutRequestDto;
import com.scaler.user_service_oct24.Dto.SignUpRequestDto;
import com.scaler.user_service_oct24.Dto.UserDto;
import com.scaler.user_service_oct24.Exceptions.SignupFailureException;
import com.scaler.user_service_oct24.Exceptions.UserNotExistException;
import com.scaler.user_service_oct24.models.Token;
import com.scaler.user_service_oct24.models.User;
import com.scaler.user_service_oct24.repositories.TokenRepo;
import com.scaler.user_service_oct24.repositories.UserRepo;
import jakarta.transaction.Transactional;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service("MySqlDBService")
@Transactional
@Primary
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepo userRepo;
//    @Autowired
//    private User_NameRepo nameRepo;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private TokenRepo tokenRepo;

    public UserServiceImpl(UserRepo userRepo /*User_NameRepo nameRepo*/, BCryptPasswordEncoder bCryptPasswordEncoder, TokenRepo tokenRepo) {
        this.userRepo = userRepo;
        this.tokenRepo = tokenRepo;
        //this.nameRepo = nameRepo;
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
//        Name name = new Name();
//        name.setFirstName(userDto.getName().getFirstName());
//        name.setLastName(userDto.getName().getLastName());
//        Name savedName = nameRepo.save(name);
//        user.setName(savedName);


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
    public User signup(SignUpRequestDto userDto) throws SignupFailureException {
        User user = new User();
        if(userDto.getEmail() == null || userDto.getPassword() == null || userDto.getUsername() == null) {
            throw new SignupFailureException("Email, Password or Username cannot be null");
        }
        user.setEmail(userDto.getEmail());
        user.setHashedPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
        user.setUsername(userDto.getUsername());

        return userRepo.save(user);

    }

//LOGIN
    LocalDate today = LocalDate.now();
    LocalDate thirtyDaysLater = today.plus(30, ChronoUnit.DAYS);
    Date expiryDate = Date.from(thirtyDaysLater.atStartOfDay(ZoneId.systemDefault()).toInstant());
    @Override
    public Token login(LogInRequestDto userDto) throws UserNotExistException, SignupFailureException {
        Optional<User> u = userRepo.findByEmail(userDto.getEmail());
        if(u.isEmpty()) {
            throw new UserNotExistException("User does not exist");
        }
        User user = u.get();
        if(! bCryptPasswordEncoder.matches(userDto.getPassword(), user.getHashedPassword())) {
            throw new SignupFailureException("Password does not match");
        }
        Token token = new Token();
        token.setUser(user);
        token.setExpiryDate(expiryDate);
        token.setValue(RandomStringUtils.randomAlphanumeric(128));

        Token savedToken = tokenRepo.save(token);
        return savedToken;
    }

    @Override
    public void logout(LogOutRequestDto dto) {

    }

}
