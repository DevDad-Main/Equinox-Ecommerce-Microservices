package com.devdad.ecommerce.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.devdad.ecommerce.dto.OrderLineRequestDTO;
import com.devdad.ecommerce.dto.OrderLineResponseDTO;
import com.devdad.ecommerce.mapper.OrderLineMapper;
import com.devdad.ecommerce.repository.OrderLineRepository;

import lombok.RequiredArgsConstructor;

/**
 * OrderLineService
 */
@Service
@RequiredArgsConstructor
public class OrderLineService {

	private final OrderLineRepository orderLineRepository;

	public Integer saveOrderLine(OrderLineRequestDTO orderLineRequest) {
		var order = OrderLineMapper.toEntity(orderLineRequest);
		return orderLineRepository.save(order).getId();
	}

	public List<OrderLineResponseDTO> findAllByOrderId(Integer orderId) {
		return orderLineRepository
			.findAllByOrderId(orderId)
			.stream()
			.map(OrderLineMapper::toOrderLineResponseDTO)
			.collect(Collectors.toList());
	}
}
