package com.example.ecommerce.domain.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

@Builder
@Getter
@Entity
@Table(name = "orders")
@AllArgsConstructor
public class Orders {


    @EmbeddedId
    private OrderId id;

    protected Orders(){
    }
}
