package com.scaler.user_service_oct24.repositories;

import com.scaler.user_service_oct24.models.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;

@Repository
public interface TokenRepo extends JpaRepository<Token, Long> {

    Token save(Token token);

    Optional<Token> findByValueAndDeletedEquals(String Token, boolean isDeleted);

    Optional<Token> findByValueAndDeletedEqualsAndExpiryDateGreaterThan(String Token, boolean isDeleted, Date expiryGreaterThan);
}
