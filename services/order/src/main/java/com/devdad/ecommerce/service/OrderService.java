package com.devdad.ecommerce.service;

import org.springframework.stereotype.Service;

import com.devdad.ecommerce.dto.OrderLineRequestDTO;
import com.devdad.ecommerce.dto.OrderRequestDTO;
import com.devdad.ecommerce.dto.PurchaseRequestDTO;
import com.devdad.ecommerce.exception.BusinessException;
import com.devdad.ecommerce.feignclient.CustomerClient;
import com.devdad.ecommerce.feignclient.ProductClient;
import com.devdad.ecommerce.mapper.OrderMapper;
import com.devdad.ecommerce.repository.OrderRepository;

import lombok.RequiredArgsConstructor;

/**
 * OrderService
 */
@Service
@RequiredArgsConstructor
public class OrderService {

	private final OrderRepository orderRepository;
	private final CustomerClient customerClient;
	private final ProductClient productClient;

	private final OrderLineService orderLineService;

	public Integer createOrder(OrderRequestDTO request) {
		// Check the customer.
		var customer = this.customerClient.findCustomerById(request.customerId())
				.orElseThrow(() -> new BusinessException(
						"Cannot create order:: No Customer exists with the provided ID." + request.customerId()));

		// Purchase the products. -> product Microservice
		this.productClient.purchaseProducts(request.products());

		// Persist order
		var order = this.orderRepository.save(OrderMapper.toEntity(request));

		// persist order lines.
		for (PurchaseRequestDTO purchaseRequest : request.products()) {
			orderLineService.saveOrderLine(
					new OrderLineRequestDTO(
						null,
						order.getId(),
						purchaseRequest.productId(),
						purchaseRequest.quantity()
						)
					);
		}

		//TODO: Initiate payment process

		// Send order confirmation -> notification microservice (kafka)
		return 1;
	}
}
