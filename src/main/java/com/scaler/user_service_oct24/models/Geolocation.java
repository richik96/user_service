package com.scaler.user_service_oct24.models;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class Geolocation{

    private Double latitude;
    private Double longitude;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;
}
