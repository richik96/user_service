package com.scaler.user_service_oct24.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;

import java.util.Date;


@Data
@Entity
public class Token extends BaseModel{

    private String value;

    @ManyToOne
    private User user;
    private Date expiryDate;
}
