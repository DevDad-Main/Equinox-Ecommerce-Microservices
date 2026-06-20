package com.devdad.ecommerce.dto;

import java.math.BigDecimal;

/**
 * PurchaseResponseDTO
 */
public record PurchaseResponseDTO(
    Integer productId,
    String name,
    String description,
    BigDecimal price,
    double quantity
    ) {
}
