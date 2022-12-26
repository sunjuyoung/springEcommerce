package com.example.ecommerce.repository;

import com.example.ecommerce.domain.order.Order;
import com.example.ecommerce.domain.order.OrderId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, OrderId> {
}
