package com.skip.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skip.api.domain.Cousine;

public interface CousineRepository extends JpaRepository<Cousine, Long>{

	List<Cousine> findByNameContainingIgnoreCase(String name);
}
