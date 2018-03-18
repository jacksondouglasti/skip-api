package com.skip.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skip.api.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

	List<Product> findByNameContainingIgnoreCase(String name);
	
	List<Product> findByStoreId(Long id);
}
