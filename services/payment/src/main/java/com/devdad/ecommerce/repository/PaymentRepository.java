package com.devdad.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.devdad.ecommerce.model.Payment;

/**
 * PaymentRepository
 */
public interface PaymentRepository extends JpaRepository<Payment, Integer> {

	
}
