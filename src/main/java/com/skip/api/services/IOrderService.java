package com.skip.api.services;

import java.util.List;

import com.skip.api.domain.Order;

public interface IOrderService {

	Order findById(Long orderId);

	Order save(Order order);

	List<Order> findByCustomerId();
}
