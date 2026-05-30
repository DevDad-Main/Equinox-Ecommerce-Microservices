package com.devdad.ecommerce.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.devdad.ecommerce.model.Customer;

/**
 * CustomerRepository
 */
public interface CustomerRepository extends MongoRepository<Customer, String> {

	
}
