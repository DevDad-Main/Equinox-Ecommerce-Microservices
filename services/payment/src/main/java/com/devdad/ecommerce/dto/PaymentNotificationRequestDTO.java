package com.devdad.ecommerce.dto;

import java.math.BigDecimal;

import com.devdad.ecommerce.model.PaymentMethod;

/**
 * PaymentNotificationRequestDTO
 */
public record PaymentNotificationRequestDTO(
		String orderReference,
		BigDecimal amount,
		PaymentMethod paymentMethod,
		String customerFirstName,
		String customerLastName,
		String customerEmail
		) {
}
