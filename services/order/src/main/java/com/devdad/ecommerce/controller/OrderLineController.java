package com.devdad.ecommerce.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devdad.ecommerce.dto.OrderLineResponseDTO;
import com.devdad.ecommerce.service.OrderLineService;

import lombok.RequiredArgsConstructor;

/**
 * OrderLineController
 */
@RestController
@RequestMapping("/api/v1/order-lines")
@RequiredArgsConstructor
public class OrderLineController {

	private final OrderLineService orderLineService;


	@GetMapping("/order/{order-id}")
	public ResponseEntity<List<OrderLineResponseDTO>> findByOrderId(
			@PathVariable("order-id") Integer orderId
			) {

		return ResponseEntity.ok(orderLineService.findAllByOrderId(orderId));

	}
}
