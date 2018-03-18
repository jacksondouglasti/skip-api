package com.skip.api.services;

import java.util.List;

import com.skip.api.domain.Product;

public interface IProductService {

	List<Product> findAll();

	Product findById(Long id);
	
	List<Product> findByName(String name);

	List<Product> findByStoreId(Long storeId);

}
