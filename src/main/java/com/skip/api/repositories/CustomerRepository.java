package com.skip.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skip.api.domain.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

	Customer findByEmail(String email);
}
