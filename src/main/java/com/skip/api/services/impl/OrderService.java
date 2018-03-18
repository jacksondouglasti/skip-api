package com.skip.api.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skip.api.domain.Order;
import com.skip.api.repositories.OrderItemRepository;
import com.skip.api.repositories.OrderRepository;
import com.skip.api.security.Authentication;
import com.skip.api.security.CustomUserDetails;
import com.skip.api.services.IOrderService;
import com.skip.api.services.exception.ObjectNotFoundException;

@Service
public class OrderService implements IOrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	@Override
	public Order findById(Long orderId) {
		return orderRepository.findById(orderId).orElseThrow(ObjectNotFoundException::new);
	}

	@Override
	public Order save(Order order) {
		Order saved = orderRepository.save(order);
		orderItemRepository.saveAll(order.getOrderItems());
		return saved;
	}

	@Override
	public List<Order> findByCustomerId() {
		CustomUserDetails user = Authentication.authenticated();
		return orderRepository.findByCustomerId(user.getId());
	}

}
