package com.example.ecommerce.dto;

import com.example.ecommerce.domain.member.Address;
import com.example.ecommerce.domain.member.Grade;
import lombok.Data;

import javax.persistence.Embedded;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
public class MemberResponse {

    private Long id;

    private String name;

    private String email;

    private Address address;

    private Grade grade;

}
