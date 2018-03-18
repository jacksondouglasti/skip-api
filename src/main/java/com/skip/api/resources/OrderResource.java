package com.skip.api.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.skip.api.domain.Order;
import com.skip.api.services.IOrderService;

@RestController
@RequestMapping(value = "/Order")
public class OrderResource {

	@Autowired
	private IOrderService orderService;
	
	@GetMapping(value = "/{orderId}")
	public ResponseEntity<Order> findById(@PathVariable Long orderId) {
		return ResponseEntity.ok(orderService.findById(orderId));
	}
	
	@GetMapping(value = "/customer")
	public ResponseEntity<List<Order>> findByCustomer() {
		return ResponseEntity.ok(orderService.findByCustomerId());
	}
	
	@PostMapping
	public ResponseEntity<Void> save(Order order) {
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{orderId}").buildAndExpand(order.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
}
