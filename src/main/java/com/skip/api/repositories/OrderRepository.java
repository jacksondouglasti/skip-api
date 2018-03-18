package com.skip.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skip.api.domain.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

	List<Order> findByCustomerId(Long customerId);
}
