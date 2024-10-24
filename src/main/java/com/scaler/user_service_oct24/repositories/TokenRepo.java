package com.scaler.user_service_oct24.repositories;

import com.scaler.user_service_oct24.models.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TokenRepo extends JpaRepository<Token, String> {

    Token save(Token token);


}
