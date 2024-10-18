package com.scaler.user_service_oct24.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "user_address")
public class Address extends BaseModel{

    private String city;
    private String street;
    private Long number;
    private String zipcode;
    @ManyToOne
    private Geolocation geoLocation;
    @ManyToOne
    private User user;
}
