package com.devdad.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devdad.ecommerce.model.Order;

/**
 * OrderRepository
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

	
}
