package com.scaler.user_service_oct24.security.models;

import com.scaler.user_service_oct24.models.Role;
import org.springframework.security.core.GrantedAuthority;

public class CustomGrantedAuthority implements GrantedAuthority {

    private Role role;
    public CustomGrantedAuthority(Role role) {
        this.role = role;
    }

    @Override
    public String getAuthority() {
        return null;
    }
}
