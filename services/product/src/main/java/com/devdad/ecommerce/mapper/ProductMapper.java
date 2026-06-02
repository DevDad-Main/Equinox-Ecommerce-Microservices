package com.devdad.ecommerce.mapper;

import com.devdad.ecommerce.dto.ProductPurchaseResponseDTO;
import com.devdad.ecommerce.dto.ProductRequestDTO;
import com.devdad.ecommerce.dto.ProductResponseDTO;
import com.devdad.ecommerce.model.Category;
import com.devdad.ecommerce.model.Product;

/**
 * ProductMapper
 */
public class ProductMapper {

	public static Product toEntity(ProductRequestDTO request) {
		return Product.builder()
				.id(request.id())
				.name(request.name())
				.description(request.description())
				.price(request.price())
				.availableQuantity(request.availableQuantity())
				.category(
						Category.builder()
								.id(request.categoryId())
								.build())
				.build();
	}

	public static ProductResponseDTO toResponseDTO(Product product) {
		return new ProductResponseDTO(
				product.getId(),
				product.getName(),
				product.getDescription(),
				product.getAvailableQuantity(),
				product.getPrice(),
				product.getCategory().getId(),
				product.getCategory().getName(),
				product.getCategory().getDescription());
	}

	public static ProductPurchaseResponseDTO toProductPurchaseResponseDTO(Product product, double quantity) {
		return new ProductPurchaseResponseDTO(
				product.getId(),
				product.getName(),
				product.getDescription(),
				product.getPrice(),
				quantity);
	}
}
