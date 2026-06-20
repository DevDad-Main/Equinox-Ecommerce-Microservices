package com.devdad.ecommerce.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * BusinessException
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BusinessException extends RuntimeException {
	private final String msg;
}
