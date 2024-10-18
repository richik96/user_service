package com.scaler.user_service_oct24.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
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

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Name name;
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Address address;
    private String phone;

}
