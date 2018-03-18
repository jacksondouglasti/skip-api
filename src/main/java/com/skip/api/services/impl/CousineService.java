package com.skip.api.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skip.api.domain.Cousine;
import com.skip.api.repositories.CousineRepository;
import com.skip.api.services.ICousineService;

@Service
public class CousineService implements ICousineService {

	@Autowired
	private CousineRepository cousineRepository;
	
	@Override
	public List<Cousine> findAll() {
		return cousineRepository.findAll();
	}

	@Override
	public List<Cousine> findByName(String searchText) {
		return cousineRepository.findByNameContainingIgnoreCase(searchText);
	}

}
