package com.devdad.ecommerce.mapper;

import com.devdad.ecommerce.dto.OrderLineRequestDTO;
import com.devdad.ecommerce.dto.OrderLineResponseDTO;
import com.devdad.ecommerce.model.Order;
import com.devdad.ecommerce.model.OrderLine;

/**
 * OrderLineMapper
 */
public class OrderLineMapper {

	public static OrderLine toEntity(OrderLineRequestDTO request) {
		return OrderLine.builder()
				.id(request.id())
				.quantity(request.quantity())
				.order(
						Order
								.builder()
								.id(request.orderId())
								.build())
				.build();
	}

	public static OrderLineResponseDTO toOrderLineResponseDTO(OrderLine orderLine) {
		return new OrderLineResponseDTO(
				orderLine.getId(),
				orderLine.getQuantity());
	}
}
