package com.skip.api.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skip.api.domain.Customer;
import com.skip.api.repositories.CustomerRepository;
import com.skip.api.services.ICustomerService;

@Service
public class CustomerService implements ICustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public Customer save(Customer customer) {
		customer.setId(null);
		return customerRepository.save(customer);
	}

}
