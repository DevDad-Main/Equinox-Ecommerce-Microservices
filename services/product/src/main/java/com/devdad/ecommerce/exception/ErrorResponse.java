package com.devdad.ecommerce.exception;

import java.util.Map;

/**
 * ErrorResponse
 */
public record ErrorResponse(
		Map<String, Object> errors
		) {
}
