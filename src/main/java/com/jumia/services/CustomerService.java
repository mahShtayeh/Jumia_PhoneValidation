package com.jumia.services;

import com.jumia.Entities.Customer;

public interface CustomerService {
	Iterable<Customer> getCustomersPage(); 
}
