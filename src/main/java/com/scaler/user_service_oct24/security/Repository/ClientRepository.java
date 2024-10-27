package com.scaler.user_service_oct24.security.Repository;

import java.util.Optional;

import com.scaler.user_service_oct24.models.Client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, String> {
    Optional<Client> findByClientId(String clientId);
}
