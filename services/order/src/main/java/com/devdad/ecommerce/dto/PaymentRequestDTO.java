package com.devdad.ecommerce.dto;

import com.devdad.ecommerce.model.PaymentMethod;

import java.math.BigDecimal;

/**
 * PaymentRequestDTO
 */
public record PaymentRequestDTO(
		Integer id,
		BigDecimal amount,
		PaymentMethod paymentMethod,
		Integer orderId,
		String orderReference,
		CustomerResponseDTO customer) {
}
