package com.scaler.user_service_oct24.repositories;

import com.scaler.user_service_oct24.models.User;

import lombok.NonNull;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {


    User findById(long id);

    @NonNull
    List<User> findAll();

    // @Query("SELECT u FROM User u " +
    //         "JOIN FETCH u.name n" +                 //eagerly fetch the name
    //         "LEFT JOIN FETCH u.address a" +         //lazy fetch the address
    //         "LEFT JOIN FETCH a.geoLocation g" +     //lazy fetch the geolocation
    //         "WHERE u.id = :id")
    // Optional<User> findUserById(@Param("id") Long id);

}
