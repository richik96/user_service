package com.scaler.user_service_oct24.repositories;

import com.scaler.user_service_oct24.models.Geolocation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GeolocationRepo extends JpaRepository<Geolocation, Long> {

}
