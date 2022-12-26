package com.example.ecommerce.domain.order;

import com.example.ecommerce.domain.member.MemberId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Entity
@Table(name = "orders")
public class Order {


    @EmbeddedId
    private OrderId id;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "order_line", joinColumns = @JoinColumn(name = "order_id"))
    @OrderColumn(name = "line_idx")
    List<OrderLine> orderLines;

    @Column(name = "order_date")
    private LocalDateTime orderDate;

    @Embedded
    private Orderer orderer;

    @Enumerated(EnumType.STRING)
    private OrderState state;

    @Column(name = "total_amounts")
    private int totalAmounts;

    @Embedded
    private ShippingInfo shippingInfo;

    protected Order(){
    }

    public Order(OrderId id, Orderer orderer, List<OrderLine> orderLines,
                 ShippingInfo shippingInfo, OrderState state) {
        setId(id);
        setOrderer(orderer);
        setOrderLines(orderLines);
        setShippingInfo(shippingInfo);
        this.state = state;
        this.orderDate = LocalDateTime.now();

    }

    private void setId(OrderId id) {
        if (id == null) throw new IllegalArgumentException("no number");
        this.id = id;
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

    private void setOrderer(Orderer orderer) {
        if (orderer == null) throw new IllegalArgumentException("no orderer");
        this.orderer = orderer;
    }




}
