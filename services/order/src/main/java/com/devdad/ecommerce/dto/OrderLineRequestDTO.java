package com.devdad.ecommerce.dto;

/**
 * OrderLineRequestDTO
 */
public record OrderLineRequestDTO(
		Integer id,
		Integer orderId,
		Integer productId,
		double quantity) {

}
