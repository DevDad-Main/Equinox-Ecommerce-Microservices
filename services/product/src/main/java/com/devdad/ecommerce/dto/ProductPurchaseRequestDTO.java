package com.devdad.ecommerce.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

/**
 * ProductPurchaseRequestDTO
 */
public record ProductPurchaseRequestDTO(
		@NotNull(message = "Product ID is mandatory.")
		Integer productId,
		@NotNull(message = "Product quantity is mandatory.")
		@Positive(message = "Product quantity must be a positive value.")
		double quantity,

		@NotNull(message = "Product price is mandatory.")
		@Positive(message = "Product price must be a positive value.")
		BigDecimal price
		) {

}
