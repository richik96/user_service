package com.scaler.user_service_oct24.repositories;

import com.scaler.user_service_oct24.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AddressRepo extends JpaRepository<Address, Long> {

}
