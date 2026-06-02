package com.devdad.ecommerce.dto;

import java.math.BigDecimal;

/**
 * ProductResponseDTO
 */
public record ProductResponseDTO(
		Integer id,
		String name,
		String description,
		double availableQuantity,
		BigDecimal price,
		Integer categoryId,
		String categoryName,
		String categoryDescription
		) {
}
