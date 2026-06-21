package com.devdad.ecommerce.dto;

import com.devdad.ecommerce.model.Customer;
import com.devdad.ecommerce.model.PaymentMethod;

/**
 * PaymentRequestDTO
 */
public record PaymentRequestDTO(
		Integer id,
		java.math.BigDecimal amount,
		PaymentMethod paymentMethod,
		Integer orderId,
		String orderReference,
		Customer customer) {

}
