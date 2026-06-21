package com.devdad.ecommerce.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devdad.ecommerce.dto.OrderRequestDTO;
import com.devdad.ecommerce.dto.OrderResponseDTO;
import com.devdad.ecommerce.service.OrderService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

/**
 * OrderController
 */
@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {

	private final OrderService orderService;

	@PostMapping
	public ResponseEntity<Integer> createOrder(
			@RequestBody @Valid OrderRequestDTO request) {

		return ResponseEntity.ok(orderService.createOrder(request));
	}

	@GetMapping
	public ResponseEntity<List<OrderResponseDTO>> findAllOrders() {
		return ResponseEntity.ok(orderService.findAllOrders());
	}

	@GetMapping("/{order-id}")
	public ResponseEntity<OrderResponseDTO> findById(
			@PathVariable("order-id") Integer orderId) {
			return ResponseEntity.ok(orderService.findById(orderId));
	}
}
