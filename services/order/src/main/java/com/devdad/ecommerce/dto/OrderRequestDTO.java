package com.devdad.ecommerce.dto;

import java.math.BigDecimal;
import java.util.List;

import com.devdad.ecommerce.model.PaymentMethod;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

/**
 * OrderRequestDTO
 */
public record OrderRequestDTO(
		Integer id,
		String orderReference,

		@Positive(message = "Order amount should be a positive value")
		BigDecimal amount,

		@NotNull(message = "Payment Method should not be null.")
		PaymentMethod paymentMethod,

		@NotNull(message = "Customer ID should be present")
		@NotEmpty(message = "Customer ID should be present")
		@NotBlank(message = "Customer ID should be present")
		String customerId,

		@NotEmpty(message = "You should purchase at least one product.")
		List<PurchaseRequestDTO> products
		) {
}
