package com.devdad.ecommerce.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * CustomerNotFoundException
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class CustomerNotFoundException extends RuntimeException {

	// No need to call the super here as the annotation above handles this for us
	private final String message;
}
