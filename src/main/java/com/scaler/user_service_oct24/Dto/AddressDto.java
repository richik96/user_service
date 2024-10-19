package com.scaler.user_service_oct24.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressDto {

    private String street;
    private String city;
    private String zipcode;
    private Long number;
    private GeolocationDto geolocation;

}
