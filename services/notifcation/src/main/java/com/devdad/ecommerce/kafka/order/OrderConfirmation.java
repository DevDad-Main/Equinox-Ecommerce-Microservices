package com.devdad.ecommerce.kafka.order;

import com.devdad.ecommerce.model.Customer;
import com.devdad.ecommerce.model.Product;
import com.devdad.ecommerce.model.PaymentMethod;
import java.math.BigDecimal;
import java.util.List;

/**
 * OrderConfirmation
 */
public record OrderConfirmation(
		String orderReference,
		BigDecimal totalAmount,
		PaymentMethod paymentMethod,
		Customer customer,
		List<Product> products) {
}
