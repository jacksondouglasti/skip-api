package com.skip.api.resources;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.skip.api.domain.Customer;
import com.skip.api.services.ICustomerService;

@RestController
@RequestMapping(value = "/Customer")
public class CustomerResource {

    @Autowired
    private ICustomerService customerService;

	@PostMapping
	public ResponseEntity<Void> save(@Valid @RequestBody Customer newCustomer) {
        Customer customer = customerService.save(newCustomer);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{customerId}").buildAndExpand(customer.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
	
}
