package com.devdad.ecommerce.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

/**
 * PurchaseRequestDTO
 */
public record PurchaseRequestDTO(
		@NotNull(message = "Product is mandatory.")
		Integer productId,

		@Positive(message = "Quantity is mandatory.")
		double quantity
		) {
}
