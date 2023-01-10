package com.example.ecommerce.domain.order;

import com.example.ecommerce.domain.product.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@AllArgsConstructor
@Table(name = "order_line")
public class OrderLine {


    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_line_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "price")
    private int price;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "amounts")
    private int amounts;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;


    protected OrderLine(){}


    public OrderLine( int price, int quantity) {

        this.price = price;
        this.quantity = quantity;
        this.amounts = price * quantity;
    }
}
