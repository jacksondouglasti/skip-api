package com.skip.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skip.api.domain.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
