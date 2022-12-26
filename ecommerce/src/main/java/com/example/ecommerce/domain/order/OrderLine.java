package com.example.ecommerce.domain.order;

import com.example.ecommerce.domain.product.ProductId;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Getter
@Embeddable
@NoArgsConstructor
public class OrderLine {

    @Embedded
    private ProductId productId;

    @Column(name = "price")
    private int price;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "amounts")
    private int amounts;


    public OrderLine(ProductId productId, int price, int quantity) {
        this.productId = productId;
        this.price = price;
        this.quantity = quantity;
        this.amounts = price * quantity;
    }
}
