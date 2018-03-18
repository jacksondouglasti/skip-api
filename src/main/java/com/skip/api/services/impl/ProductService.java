package com.skip.api.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skip.api.domain.Product;
import com.skip.api.repositories.ProductRepository;
import com.skip.api.services.IProductService;
import com.skip.api.services.exception.ObjectNotFoundException;

@Service
public class ProductService implements IProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public List<Product> findAll() {
		return productRepository.findAll();
	}

	@Override
	public Product findById(Long id) {
		return productRepository.findById(id).orElseThrow(ObjectNotFoundException::new);
	}

	@Override
	public List<Product> findByName(String name) {
		return productRepository.findByNameContainingIgnoreCase(name);
	}

	@Override
	public List<Product> findByStoreId(Long storeId) {
		return productRepository.findByStoreId(storeId);
	}

}
