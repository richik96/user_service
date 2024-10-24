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

    User save(User user);
    User findById(long id);

    @Query("select u1_0.id,u1_0.email,u1_0.hashedPassword,u1_0.isDeleted," +
            "u1_0.isEmailVerify,u1_0.name,u1_0.username from User u1_0" +
            " where u1_0.email = :email")
//    @Query("select distinct from User where email = :email")
    Optional<User> findByEmail(@Param("email") String email);

    @NonNull
    List<User> findAll();

    // @Query("SELECT u FROM User u " +
    //         "JOIN FETCH u.name n" +                 //eagerly fetch the name
    //         "LEFT JOIN FETCH u.address a" +         //lazy fetch the address
    //         "LEFT JOIN FETCH a.geoLocation g" +     //lazy fetch the geolocation
    //         "WHERE u.id = :id")
    // Optional<User> findUserById(@Param("id") Long id);

}
