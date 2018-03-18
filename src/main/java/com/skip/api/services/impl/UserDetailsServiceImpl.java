package com.skip.api.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.skip.api.domain.Customer;
import com.skip.api.repositories.CustomerRepository;
import com.skip.api.security.CustomUserDetails;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Customer customer = customerRepository.findByEmail(email);

        if (customer == null) {
            throw new UsernameNotFoundException(email);
        }

        return new CustomUserDetails(customer.getId(), customer.getEmail(), customer.getPassword(), customer.getRoles());
    }
}
