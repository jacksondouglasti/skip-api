package com.skip.api.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skip.api.domain.Product;
import com.skip.api.domain.Store;
import com.skip.api.services.IProductService;
import com.skip.api.services.IStoreService;

@RestController
@RequestMapping(value = "/Store")
public class StoreResource {

	@Autowired
	private IStoreService storeService;
	
	@Autowired
	private IProductService productService;
	
	@GetMapping
	public ResponseEntity<List<Store>> findAll() {
		return ResponseEntity.ok(storeService.findAll());
	}
	
	@GetMapping(value = "/{storeId}")
	public ResponseEntity<Store> findById(@PathVariable Long storeId) {
		return ResponseEntity.ok(storeService.findById(storeId));
	}
	
	@GetMapping(value = "/search/{searchText}")
	public ResponseEntity<List<Store>> findByName(@PathVariable String searchText) {
		return ResponseEntity.ok(storeService.findByName(searchText));
	}

	@GetMapping(value = "/{storeId}/products")
	public ResponseEntity<List<Product>> findProductsByStoreId(@PathVariable Long storeId) {
		return ResponseEntity.ok(productService.findByStoreId(storeId));
	}
}
