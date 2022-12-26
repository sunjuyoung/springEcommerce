package com.example.ecommerce.domain.order;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Access(AccessType.FIELD)
@EqualsAndHashCode(of = "id")
public class OrderId implements Serializable {

    @Column(name = "order_id")
    private Long id;

    protected OrderId() {
    }

    public OrderId(Long id) {
        this.id = id;
    }
    public static OrderId of(Long id) {
        return new OrderId(id);
    }
}
