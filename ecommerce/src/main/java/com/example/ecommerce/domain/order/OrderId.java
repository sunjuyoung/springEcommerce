package com.example.ecommerce.domain.order;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Getter
@EqualsAndHashCode(of = "id")
public class OrderId implements Serializable {

    @Column(name = "order_id")
    private String id;

    protected OrderId() {
    }

    public OrderId(String id) {
        this.id = id;
    }
    public static OrderId of(String id) {
        return new OrderId(id);
    }
}
