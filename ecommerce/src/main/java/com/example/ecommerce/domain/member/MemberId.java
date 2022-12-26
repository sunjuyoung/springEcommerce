package com.example.ecommerce.domain.member;

import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
@EqualsAndHashCode(of = "id")
@Access(AccessType.FIELD)
public class MemberId implements Serializable {

    @Column(name = "member_id")
    private Long id;

    protected MemberId() {
    }
    public Long getId(){
        return id;
    }
    public MemberId(Long id) {
        this.id = id;
    }
    public static MemberId of(Long id) {
        return new MemberId(id);
    }
}
