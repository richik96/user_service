package com.scaler.user_service_oct24.repositories;

import com.scaler.user_service_oct24.models.User;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@Transactional
@Rollback
class UserRepoTest {

    @Autowired
    private UserRepo userRepo;

    @Test
    void testFindByEmail() {

        //create a new user
        User user = new User();
        user.setEmail("test@mail.com");
        user.setHashedPassword("hashedPass");
        userRepo.save(user);

        //retrieve the user by mail

        Optional<User> retrievedUser = userRepo.findByEmail("test@mail.com");

        if (retrievedUser.isPresent()) {
            System.out.println("User found: " + retrievedUser.get().getEmail());
        } else {
            System.out.println("User not found");
        }
        //verify
        assertTrue(retrievedUser.isPresent());
        assertEquals("test@mail.com", retrievedUser.get().getEmail());

    }
}