package com.example.ecommerce.domain.member;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

@Builder
@Getter
@Entity
@AllArgsConstructor
public class Member {


    @EmbeddedId
    private MemberId id;

    private String name;
    private String password;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)
    private Grade grade;


    protected Member(){
    }

}
