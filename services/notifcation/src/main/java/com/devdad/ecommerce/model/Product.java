package com.devdad.ecommerce.model;
import java.math.BigDecimal;
/**
 * Product
 */
public record Product(
		Integer productId,
		String name,
		String description,
		BigDecimal price,
		double quantity
		) {
}
