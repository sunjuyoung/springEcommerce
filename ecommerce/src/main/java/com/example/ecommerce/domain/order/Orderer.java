package com.example.ecommerce.domain.order;

import com.example.ecommerce.domain.member.MemberId;
import lombok.EqualsAndHashCode;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@EqualsAndHashCode(of = "memberId")
public class Orderer {

    @AttributeOverrides(
            @AttributeOverride(name = "id", column = @Column(name = "orderer_id"))
    )
    private MemberId memberId;

    @Column(name = "orderer_name")
    private String name;

    protected Orderer() {
    }

    public Orderer(MemberId memberId, String name) {
        this.memberId = memberId;
        this.name = name;
    }

}
