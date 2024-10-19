package com.scaler.user_service_oct24.repositories;

import com.scaler.user_service_oct24.models.Name;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface User_NameRepo extends JpaRepository<Name, Long> {

}
