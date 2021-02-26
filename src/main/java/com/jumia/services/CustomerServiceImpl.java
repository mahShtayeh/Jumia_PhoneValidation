package com.jumia.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jumia.Entities.Customer;
import com.jumia.repositories.CustomerRepository;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerRepository customerRepository; 
	
	@Override
	public Iterable<Customer> getCustomersPage() {
		return customerRepository.findAll();
	} 
	
}
