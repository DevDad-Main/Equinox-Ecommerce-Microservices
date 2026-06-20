package com.devdad.ecommerce.mapper;

import com.devdad.ecommerce.dto.OrderRequestDTO;
import com.devdad.ecommerce.model.Order;

/**
 * OrderMapper
 */
public class OrderMapper {

	public static Order toEntity(OrderRequestDTO request){
		return Order.builder()
			.id(request.id())
			.customerId(request.customerId())
			.reference(request.orderReference())
			.totalAmount(request.amount())
			.paymentMethod(request.paymentMethod())
			.build();
	}
}
