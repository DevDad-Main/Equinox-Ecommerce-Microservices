package com.devdad.ecommerce.service;

import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import org.springframework.stereotype.Service;

import com.devdad.ecommerce.dto.ProductPurchaseRequestDTO;
import com.devdad.ecommerce.dto.ProductPurchaseResponseDTO;
import com.devdad.ecommerce.dto.ProductRequestDTO;
import com.devdad.ecommerce.dto.ProductResponseDTO;
import com.devdad.ecommerce.exception.PriceMismatchException;
import com.devdad.ecommerce.exception.ProductPurchaseException;
import com.devdad.ecommerce.mapper.ProductMapper;
import com.devdad.ecommerce.repository.ProductRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

/**
 * ProductService
 */
@RequiredArgsConstructor
@Service
public class ProductService {

	private final ProductRepository repository;

	public Integer createProduct(ProductRequestDTO request) {
		return repository.save(ProductMapper.toEntity(request)).getId();
	}

	public List<ProductPurchaseResponseDTO> purchasableProducts(List<ProductPurchaseRequestDTO> request) {
		var productIds = request
				.stream()
				.map(ProductPurchaseRequestDTO::productId)
				.toList();

		var exisitingProducts = repository.findAllByIdInOrderById(productIds);

		if (productIds.size() != exisitingProducts.size()) {
			throw new ProductPurchaseException("One or more products do not exist.");
		}

		var storedRequest = request.stream().sorted(Comparator.comparing(ProductPurchaseRequestDTO::productId)).toList();
		var purchasedProducts = new ArrayList<ProductPurchaseResponseDTO>();

		for (int i = 0; i < exisitingProducts.size(); i++) {
			var product = exisitingProducts.get(i);
			var productRequest = storedRequest.get(i);

			// NOTE: Quantity check.
			if (product.getAvailableQuantity() < productRequest.quantity()) {
				throw new ProductPurchaseException(
						"Insufficient stock quantity for product with ID:: " + productRequest.productId());
			}

			//NOTE: compareTo returns:
			// 0 if equal
			// -1 if request price is less than DB price
			// 1 if request price is greater than DB price
			if (productRequest.price().compareTo(product.getPrice()) != 0) {
				throw new PriceMismatchException("Requested product price does not match the database price.");
			}

			var newAvailableQuantity = product.getAvailableQuantity() - productRequest.quantity();
			product.setAvailableQuantity(newAvailableQuantity);
			repository.save(product);
			purchasedProducts.add(ProductMapper.toProductPurchaseResponseDTO(product, productRequest.quantity()));
		}

		return purchasedProducts;
	}

	public ProductResponseDTO findProductById(Integer productId) {
		return repository.findById(productId)
				.map(ProductMapper::toResponseDTO)
				.orElseThrow(() -> new EntityNotFoundException("Product not found with the ID:: " + productId));
	}

	public List<ProductResponseDTO> findAllProducts() {
		return repository
				.findAll()
				.stream()
				.map(ProductMapper::toResponseDTO)
				.toList();
	}

}
