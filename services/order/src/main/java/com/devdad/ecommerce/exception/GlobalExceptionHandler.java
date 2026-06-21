package com.devdad.ecommerce.exception;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.persistence.EntityNotFoundException;

/**
 * GlobalExceptionHandler
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(BusinessException.class)
	public ResponseEntity<String> handleException(BusinessException exception) {
		return ResponseEntity
				.status(HttpStatus.BAD_REQUEST)
				.body(exception.getMsg());
	}

	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<String> handleException(EntityNotFoundException exception) {
		return ResponseEntity
				.status(HttpStatus.BAD_REQUEST)
				.body(exception.getMessage());
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponse> handleException(MethodArgumentNotValidException exception) {

		var errors = new HashMap<String, Object>();
		exception.getBindingResult()
				.getAllErrors()
				.forEach(error -> {
					var fieldName = ((FieldError) error).getField();
					var errorMessage = error.getDefaultMessage();
					errors.put(fieldName, errorMessage);
				});

		return ResponseEntity
				.status(HttpStatus.BAD_REQUEST)
				.body(new ErrorResponse(errors));
	}
}
