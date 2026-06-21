package com.devdad.ecommerce.mapper;

import com.devdad.ecommerce.dto.PaymentRequestDTO;
import com.devdad.ecommerce.model.Payment;

/**
 * PaymentMapper
 */
public class PaymentMapper {

	public static Payment toEntity(PaymentRequestDTO request) {
		return Payment.builder()
				.id(request.id())
				.orderId(request.orderId())
				.paymentMethod(request.paymentMethod())
				.amount(request.amount())
				.build();
	}
}
