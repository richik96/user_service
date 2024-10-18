package com.scaler.user_service_oct24.models;


import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
@Entity(name = "user_geolocation")
public class Geolocation extends BaseModel{

    private Double latitude;
    private Double longitude;
    @OneToOne
    private Address address;
    @OneToOne
    private User user;
}
