package com.skip.api.services;

import java.util.List;

import com.skip.api.domain.Store;

public interface IStoreService {

	List<Store> findByCousineId(Long id);

	List<Store> findAll();

	Store findById(Long id);

	List<Store> findByName(String searchText);
}
