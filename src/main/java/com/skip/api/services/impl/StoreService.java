package com.skip.api.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skip.api.domain.Store;
import com.skip.api.repositories.StoreRepository;
import com.skip.api.services.IStoreService;
import com.skip.api.services.exception.ObjectNotFoundException;

@Service
public class StoreService implements IStoreService {
	
	@Autowired
	private StoreRepository storeRepository;
	
	@Override
	public List<Store> findByCousineId(Long id) {
		return storeRepository.findByCousineId(id);
	}

	@Override
	public List<Store> findAll() {
		return storeRepository.findAll();
	}

	@Override
	public Store findById(Long id) {
		return storeRepository.findById(id).orElseThrow(ObjectNotFoundException::new);
	}

	@Override
	public List<Store> findByName(String searchText) {
		return storeRepository.findByNameContainingIgnoreCase(searchText);
	}

}
