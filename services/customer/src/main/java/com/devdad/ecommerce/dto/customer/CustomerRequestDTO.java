package com.devdad.ecommerce.dto.customer;

import com.devdad.ecommerce.model.Address;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

/**
 * CustomerRequestDTO
 */
public record CustomerRequestDTO(

	 String id,

	 @NotNull(message = "Customer firstName is required")
	 String firstName,

	 @NotNull(message = "Customer lastName is required")
	 String lastName,

	 @NotNull(message = "Customer email is required")
	 @Email(message = "Customer email is not a valid email address")
	 String email,
	 Address address
		) {
}
