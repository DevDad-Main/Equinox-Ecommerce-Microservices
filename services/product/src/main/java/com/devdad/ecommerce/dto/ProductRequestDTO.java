package com.devdad.ecommerce.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

/**
 * ProductRequestDTO
 */
public record ProductRequestDTO(

		Integer id,

		@NotNull(message = "Product name is required.") String name,

		@NotNull(message = "Product description is required.") String description,

		@Positive(message = "Available quantity must be a positive value.") double availableQuantity,

		@Positive(message = "Price must be a positive value.") BigDecimal price,

		@NotNull(message = "Product category is required") Integer categoryId) {
}
