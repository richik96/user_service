package com.scaler.user_service_oct24.security.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.scaler.user_service_oct24.models.Role;
import org.springframework.security.core.GrantedAuthority;


@JsonDeserialize
public class CustomGrantedAuthority implements GrantedAuthority {

    private String authority;
    //private Role role;
    public CustomGrantedAuthority(Role role) {
        //this.role = role;
        this.authority = role.getName();
    }

    public CustomGrantedAuthority() {
    }

    @Override
    public String getAuthority() {
        //return role.getName();
        return authority;
    }
}
