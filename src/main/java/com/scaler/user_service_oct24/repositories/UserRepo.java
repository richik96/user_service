package com.scaler.user_service_oct24.repositories;

import com.scaler.user_service_oct24.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {

}
