package com.scaler.user_service_oct24.models;


import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Role extends BaseModel{

    private String name;

}
