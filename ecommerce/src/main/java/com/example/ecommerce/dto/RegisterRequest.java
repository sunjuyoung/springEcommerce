package com.example.ecommerce.dto;

import lombok.Data;

@Data
public class RegisterRequest {

    private String email;
    private String name;
    private String password;
}
