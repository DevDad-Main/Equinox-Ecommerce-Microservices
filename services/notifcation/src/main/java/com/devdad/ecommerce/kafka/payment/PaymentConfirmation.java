package com.devdad.ecommerce.kafka.payment;

import com.devdad.ecommerce.model.PaymentMethod;

import java.math.BigDecimal;

/**
 * PaymentConfirmation
 */
public record PaymentConfirmation(
		String orderReference,
		BigDecimal amount,
		PaymentMethod paymentMethod,
		String customerFirstname,
		String customerLastname,
		String customerEmail) {
}
