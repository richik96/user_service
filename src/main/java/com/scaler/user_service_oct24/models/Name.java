package com.scaler.user_service_oct24.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "user_name")
public class Name extends BaseModel {

    private String firstName;
    private String lastName;

    @JsonBackReference
    @OneToOne(mappedBy = "name")
    private User user;
}

