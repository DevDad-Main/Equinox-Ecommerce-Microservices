package com.devdad.ecommerce.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devdad.ecommerce.dto.customer.CustomerRequestDTO;
import com.devdad.ecommerce.dto.customer.CustomerResponseDTO;
import com.devdad.ecommerce.service.CustomerService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

/**
 * CustomerController
 */
@RestController
@RequestMapping("/api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {

	private final CustomerService customerService;

	@PostMapping
	public ResponseEntity<String> createCustomer(@RequestBody @Valid CustomerRequestDTO request) {
		return ResponseEntity.ok(customerService.createCustomer(request));
	}

	@PutMapping
	public ResponseEntity<Void> updateCustomer(@RequestBody @Valid CustomerRequestDTO request) {
		customerService.updateCustomer(request);
		return ResponseEntity.accepted().build();
	}

	@GetMapping
	public ResponseEntity<List<CustomerResponseDTO>> findAllCustomers() {
		return ResponseEntity.ok(customerService.findAllCustomers());
	}

	@GetMapping("/exists/{customerId}")
	public ResponseEntity<Boolean> customerExistsById(
			@PathVariable("customerId") String customerId) {
		return ResponseEntity.ok(customerService.existsById(customerId));
	}

	@GetMapping("/{customerId}")
	public ResponseEntity<CustomerResponseDTO> findCustomerById(
			@PathVariable("customerId") String customerId) {
		return ResponseEntity.ok(customerService.findById(customerId));
	}

	@DeleteMapping("/{customerId}")
	public ResponseEntity<Void> deleteById(
			@PathVariable("customerId") String customerId) {
		customerService.deleteCustomer(customerId);
		return ResponseEntity.accepted().build();
	}

}
