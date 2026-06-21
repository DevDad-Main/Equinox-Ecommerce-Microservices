package com.devdad.ecommerce.dto;

import java.math.BigDecimal;

import com.devdad.ecommerce.model.PaymentMethod;

/**
 * OrderResponseDTO
 */
public record OrderResponseDTO(
		Integer id,
		String orderReference,
		BigDecimal amount,
		PaymentMethod paymentMethod,
		String customerId
		) {
}
