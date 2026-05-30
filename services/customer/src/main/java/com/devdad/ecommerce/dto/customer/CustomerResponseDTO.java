package com.devdad.ecommerce.dto.customer;

import com.devdad.ecommerce.model.Address;

/**
 * CustomerResponseDTO
 */
public record CustomerResponseDTO(
	 String id,
	 String firstName,
	 String lastName,
	 String email,
	 Address address
		) {
} 

	
