package com.devdad.ecommerce.exception;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * GlobalExceptionHandler
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<String> handleException(CustomerNotFoundException exception){
		return ResponseEntity
			.status(HttpStatus.NOT_FOUND)
			.body(exception.getMessage());
	}

	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleException(MethodArgumentNotValidException exception){

		var errors = new HashMap<String, Object>();
		exception.getBindingResult()
			.getAllErrors()
			.forEach(error -> {
				var fieldName = ((FieldError)error).getField();
				var errorMessage = error.getDefaultMessage();
				errors.put(fieldName, errorMessage);
			});

		return ResponseEntity
			.status(HttpStatus.BAD_REQUEST)
			.body(new ErrorResponse(errors));
	}
}
