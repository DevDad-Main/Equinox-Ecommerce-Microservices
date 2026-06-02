package com.devdad.ecommerce.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devdad.ecommerce.dto.ProductPurchaseRequestDTO;
import com.devdad.ecommerce.dto.ProductPurchaseResponseDTO;
import com.devdad.ecommerce.dto.ProductRequestDTO;
import com.devdad.ecommerce.dto.ProductResponseDTO;
import com.devdad.ecommerce.service.ProductService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * ProductController
 */
@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

	private final ProductService service;

	@PostMapping
	public ResponseEntity<Integer> createProduct(@RequestBody @Valid ProductRequestDTO request) {
		return ResponseEntity.ok(service.createProduct(request));
	}

	@PostMapping("/purchase")
	public ResponseEntity<List<ProductPurchaseResponseDTO>> purchasableProducts(
			@RequestBody List<ProductPurchaseRequestDTO> request) {

		return ResponseEntity.ok(service.purchasableProducts(request));
	}

	@GetMapping("/{product-id}")
	public ResponseEntity<ProductResponseDTO> findProductById(@PathVariable("product-id") Integer productId) {
		return ResponseEntity.ok(service.findProductById(productId));
	}

	// TODO: Add pagination
	@GetMapping
	public ResponseEntity<List<ProductResponseDTO>> findAllProducts(){
		return ResponseEntity.ok(service.findAllProducts());
	}

}
