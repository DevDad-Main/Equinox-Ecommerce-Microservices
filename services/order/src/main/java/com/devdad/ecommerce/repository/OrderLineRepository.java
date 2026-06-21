package com.devdad.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devdad.ecommerce.model.OrderLine;

/**
 * OrderLineRepository
 */
@Repository
public interface OrderLineRepository extends JpaRepository<OrderLine, Integer> {

	List<OrderLine> findAllByOrderId(Integer orderId);
}
