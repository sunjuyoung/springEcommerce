package com.example.ecommerce.domain.member;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Getter
@Entity
public class Member {


    @EmbeddedId
    private MemberId id;

    private String name;
    private String password;
    private String email;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)
    private Grade grade;


    protected Member(){
    }

    public Member(MemberId id, String name, String password,String email) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.grade = Grade.GUEST;
    }
}
