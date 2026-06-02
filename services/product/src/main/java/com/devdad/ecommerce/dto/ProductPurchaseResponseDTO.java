package com.devdad.ecommerce.dto;

import java.math.BigDecimal;

/**
 * ProductPurchaseResponseDTO
 */
public record ProductPurchaseResponseDTO(
		Integer productId,
		String name,
		String description,
		BigDecimal price,
		double quantity
		) {
}
