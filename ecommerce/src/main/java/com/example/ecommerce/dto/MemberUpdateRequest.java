package com.example.ecommerce.dto;

import com.example.ecommerce.domain.member.Address;
import com.example.ecommerce.domain.member.Grade;
import lombok.Data;

@Data
public class MemberUpdateRequest {

    private String name;

    private String email;

    private String city;
    private String street;
    private String zipcode;

    private String grade;
}
