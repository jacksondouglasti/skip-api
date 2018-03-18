package com.skip.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skip.api.domain.Store;

public interface StoreRepository extends JpaRepository<Store, Long>{

	List<Store> findByCousineId(Long id);
	
	List<Store> findByNameContainingIgnoreCase(String name);
}
