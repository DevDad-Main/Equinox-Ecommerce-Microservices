package com.devdad.ecommerce.dto;

/**
 * CustomerResponseDTO
 */
public record CustomerResponseDTO(
		String id,
		String firstName,
		String lastName,
		String email
		) {
}
