package com.scaler.user_service_oct24.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class User extends BaseModel{

    private String email;
    private String username;
    private String password;
    @OneToOne
    private Name name;
    @OneToOne
    private Geolocation geolocation;
    @OneToOne
    private Address address;
    private String phone;

}
