package com.scaler.user_service_oct24.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class User extends BaseModel{

    private String email;
    private String username;
    private String hashedPassword;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "name_id")
    @JsonManagedReference
    private Name name;
    @ManyToMany(cascade = {CascadeType.ALL})
    private List<Role> role;
    private boolean isEmailVerify;
}
