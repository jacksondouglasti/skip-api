package com.skip.api.services;

import java.util.List;

import com.skip.api.domain.Cousine;

public interface ICousineService {

	List<Cousine> findAll();

	List<Cousine> findByName(String searchText);

}
