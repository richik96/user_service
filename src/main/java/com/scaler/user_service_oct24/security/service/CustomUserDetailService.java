package com.scaler.user_service_oct24.security.service;

import com.scaler.user_service_oct24.security.models.CustomUserDetails;
import com.scaler.user_service_oct24.models.User;
import com.scaler.user_service_oct24.repositories.UserRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public class CustomUserDetailService implements UserDetailsService {

    private UserRepo userRepo;
    public CustomUserDetailService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> userOptional = userRepo.findByUsername(username);
        if(userOptional.isEmpty())
            throw new UsernameNotFoundException("User "+username + " not found");

        CustomUserDetails customUserDetails = new CustomUserDetails(userOptional.get());
        return customUserDetails;
    }
}
