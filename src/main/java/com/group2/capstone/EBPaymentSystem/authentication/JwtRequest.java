package com.group2.capstone.EBPaymentSystem.authentication;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class JwtRequest {
    private String username;
    private String password;

    // Constructors, getters, and setters

    // ...
}

