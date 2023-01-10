package com.example.ecommerce.domain.order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import net.bytebuddy.asm.Advice;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@AllArgsConstructor
@Table(name = "orders")
public class Order {


    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_id")
    private Long id;


    @OneToMany(mappedBy = "order",
            cascade = CascadeType.REMOVE,
            orphanRemoval = true)
    private List<OrderLine> orderLines = new ArrayList<>();

    @Column(name = "order_date")
    private LocalDateTime orderDate;


    @Enumerated(EnumType.STRING)
    private OrderState state;

    @Column(name = "total_amounts")
    private int totalAmounts;

    @Embedded
    private ShippingInfo shippingInfo;

    @OneToOne
    private Delivery delivery;


    protected Order(){
    }

    public Order( List<OrderLine> orderLines,
                 ShippingInfo shippingInfo, OrderState state) {

        setOrderLines(orderLines);
        setShippingInfo(shippingInfo);
        this.state = state;
        this.orderDate = LocalDateTime.now();

    }



    private void setShippingInfo(ShippingInfo shippingInfo) {
        if (shippingInfo == null) throw new IllegalArgumentException("no shipping info");
        this.shippingInfo = shippingInfo;
    }

    private void setOrderLines(List<OrderLine> orderLines) {
        if (orderLines == null || orderLines.isEmpty()) {
            throw new IllegalArgumentException("no OrderLine");
        }
        this.orderLines = orderLines;
        this.totalAmounts = orderLines.stream().mapToInt(x -> x.getAmounts()).sum();
    }



    public void changeShippingInfo(ShippingInfo newShippingInfo){
        if(!isNotYetShipped()){
            throw new RuntimeException("can not be changed after ship ");
        }
        setShippingInfo(newShippingInfo);
    }
    public void cancel(){
        if(!isNotYetShipped()){
            throw new RuntimeException("can not be cancel ");
        }
        this.state = OrderState.CANCELED;
    }

    private boolean isNotYetShipped(){
        return state == OrderState.PAYMENT_WAITING || state ==OrderState.PREPARING;
    }



}
