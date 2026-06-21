package com.devdad.ecommerce.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.devdad.ecommerce.service.PaymentService;
import com.devdad.ecommerce.dto.PaymentRequestDTO;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * PaymentController
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/payments")
public class PaymentController {

	private final PaymentService paymentService;

	@PostMapping
	public ResponseEntity<Integer> createPayment(
			@RequestBody @Valid PaymentRequestDTO request) {
		// TODO: process POST request

		return ResponseEntity.ok(paymentService.createPayment(request));
	}

}
