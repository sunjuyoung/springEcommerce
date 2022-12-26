
package com.example.ecommerce.domain.product;


import com.example.ecommerce.domain.order.OrderId;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@EqualsAndHashCode(of = "id")
@Access(AccessType.FIELD)
public class ProductId implements Serializable {

    @Column(name = "product_id")
    private String id;

    protected ProductId() {
    }

    public String getId(){
        return id;
    }

    public ProductId(String id) {
        this.id = id;
    }
    public static ProductId of(String id) {
        return new ProductId(id);
    }
}
