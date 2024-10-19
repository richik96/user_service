package com.scaler.user_service_oct24.repositories;

import com.scaler.user_service_oct24.models.Geolocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeolocationRepo extends JpaRepository<Geolocation, Long> {


}
