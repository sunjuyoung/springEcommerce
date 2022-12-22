
package com.example.ecommerce.domain.product;


import com.example.ecommerce.domain.order.OrderId;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Getter
@EqualsAndHashCode(of = "id")
public class ProductId implements Serializable {

    @Column(name = "product_id")
    private String id;

    protected ProductId() {
    }

    public ProductId(String id) {
        this.id = id;
    }
    public static ProductId of(String id) {
        return new ProductId(id);
    }
}
