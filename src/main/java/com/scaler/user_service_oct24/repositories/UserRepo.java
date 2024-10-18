package com.scaler.user_service_oct24.repositories;

import com.scaler.user_service_oct24.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepo extends JpaRepository<User, Long> {


    User findById(long id);

    List<User> findAll();

}
