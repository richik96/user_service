package com.scaler.user_service_oct24.repositories;

import com.scaler.user_service_oct24.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {


    User findById(long id);

    List<User> findAll();

}
