package com.devdad.ecommerce.kafka;

import java.math.BigDecimal;
import java.util.List;

import com.devdad.ecommerce.dto.CustomerResponseDTO;
import com.devdad.ecommerce.dto.PurchaseResponseDTO;
import com.devdad.ecommerce.model.PaymentMethod;

/**
 * OrderConfirmationDTO
 */
public record OrderConfirmationDTO(
		String orderReference,
		BigDecimal totalAmount,
		PaymentMethod paymentMethod,
		CustomerResponseDTO customer, // Contains a customers inforamtion
		List<PurchaseResponseDTO> products
		) {
}
