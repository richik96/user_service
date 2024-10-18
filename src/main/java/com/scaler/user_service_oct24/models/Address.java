package com.scaler.user_service_oct24.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name = "user_address")
public class Address extends BaseModel{

    private String city;
    private String street;
    private Long number;
    private String zipcode;
    @Embedded
    private Geolocation geoLocation;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
