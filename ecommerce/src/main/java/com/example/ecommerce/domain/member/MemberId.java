package com.example.ecommerce.domain.member;

import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
@EqualsAndHashCode(of = "id")
public class MemberId implements Serializable {

    @Column(name = "member_id")
    private Long id;

    protected MemberId() {
    }
    public MemberId(Long id) {
        this.id = id;
    }
    public static MemberId of(Long id) {
        return new MemberId(id);
    }
}
