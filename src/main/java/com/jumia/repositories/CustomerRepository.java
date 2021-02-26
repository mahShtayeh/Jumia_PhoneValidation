package com.jumia.repositories;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jumia.Entities.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
