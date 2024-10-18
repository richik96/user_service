package com.scaler.user_service_oct24.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "user_name")
public class Name extends BaseModel {

    private String firstName;
    private String lastName;

    @OneToOne
    private User user;
}

