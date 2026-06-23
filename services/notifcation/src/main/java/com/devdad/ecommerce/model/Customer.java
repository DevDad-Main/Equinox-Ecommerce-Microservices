
package com.devdad.ecommerce.model;

import org.springframework.validation.annotation.Validated;

/**
 * Customer
 */
@Validated // Ensures whenever this record is used it will be validated also if parent
						// calls @Valid
public record Customer(
		String id,

		String firstName,

		String lastName,

		String email) {
}
