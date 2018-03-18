package com.skip.api.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skip.api.domain.Product;
import com.skip.api.services.IProductService;

@RestController
@RequestMapping(value = "/Product")
public class ProductResource {

	@Autowired
	private IProductService productService;
	
	@GetMapping
	public ResponseEntity<List<Product>> findAll() {
		return ResponseEntity.ok(productService.findAll());
	}
	
	@GetMapping(value = "/{productId}")
	public ResponseEntity<Product> findById(@PathVariable Long productId) {
		return ResponseEntity.ok(productService.findById(productId));
	}
	
	@GetMapping(value = "/search/{searchText}")
	public ResponseEntity<List<Product>> findByName(@PathVariable String searchText) {
		return ResponseEntity.ok(productService.findByName(searchText));
	}
	
}
