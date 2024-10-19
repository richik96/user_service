package com.scaler.user_service_oct24.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
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

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "geoLocation_id")
    @JsonManagedReference
    private Geolocation geoLocation;

    @OneToOne(mappedBy = "address")
    @JsonBackReference
    @JoinColumn(name = "user_id")
    private User user;
}
