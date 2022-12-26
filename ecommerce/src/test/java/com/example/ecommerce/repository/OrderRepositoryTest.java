package com.example.ecommerce.repository;


import com.example.ecommerce.domain.member.Address;
import com.example.ecommerce.domain.member.Member;
import com.example.ecommerce.domain.member.MemberId;
import com.example.ecommerce.domain.order.*;
import com.example.ecommerce.domain.product.Product;
import com.example.ecommerce.domain.product.ProductId;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrderRepositoryTest {

    @Autowired
    private OrderRepository orderRepository;

    @Test
    public void test() throws Exception{
        //given
        Member member = new Member(new MemberId(1L),"test","1234","test");
        Address address = new Address("test","test","test");
        ShippingInfo shippingInfo = new ShippingInfo(address,member.getName(),"test");
        ProductId productId = new ProductId("prod-001");
        ProductId productId1 = new ProductId("prod-002");
        List<OrderLine> orderLineList = new ArrayList<>();
        OrderLine orderLine = new OrderLine(productId,1000,3);
        OrderLine orderLine1 = new OrderLine(productId1,2000,2);
        orderLineList.add(orderLine);
        orderLineList.add(orderLine1);
        Order order = new Order(new OrderId(2L),
                new Orderer(member.getId(),member.getName()),
                orderLineList,
                shippingInfo,
                OrderState.PAYMENT_WAITING
                );

        orderRepository.save(order);

        //when

        //then
    }
}