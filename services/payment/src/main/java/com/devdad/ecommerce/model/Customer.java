package com.devdad.ecommerce.model;

import org.springframework.validation.annotation.Validated;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

/**
 * Customer
 */
@Validated // Ensures whenever this record is used it will be validated also if parent calls @Valid
public record Customer(
		String id,

		@NotNull(message = "Firstname is required")
		String firstName,

		@NotNull(message = "Lastname is required")
		String lastName,

		@NotNull(message = "Email is required")
		@Email(message = "Customer email is not a correct email format.")
		String email
		) {
}
