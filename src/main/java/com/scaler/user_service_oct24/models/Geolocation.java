package com.scaler.user_service_oct24.models;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "geolocation")
public class Geolocation extends BaseModel{

    private Double latitude;
    private Double longitude;

    @OneToOne(mappedBy = "geoLocation")
    @JoinColumn(name = "address_id")
    private Address address;
}
