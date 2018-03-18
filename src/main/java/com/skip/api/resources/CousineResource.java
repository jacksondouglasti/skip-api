package com.skip.api.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skip.api.domain.Cousine;
import com.skip.api.domain.Store;
import com.skip.api.services.ICousineService;
import com.skip.api.services.IStoreService;

@RestController
@RequestMapping(value = "/Cousine")
public class CousineResource {

	@Autowired
	private ICousineService cousineService;
	
	@Autowired
	private IStoreService storeService;
	
	@GetMapping
	public ResponseEntity<List<Cousine>> findAll() {
		return ResponseEntity.ok(cousineService.findAll());
	}
	
	@GetMapping(value = "/search/{searchText}")
	public ResponseEntity<List<Cousine>> findByName(@PathVariable String searchText) {
		return ResponseEntity.ok(cousineService.findByName(searchText));
	}
	
	@GetMapping(value = "/{cousineId}/stores")
	public ResponseEntity<List<Store>> findStores(@PathVariable Long cousineId) {
		return ResponseEntity.ok(storeService.findByCousineId(cousineId));
	}
}
