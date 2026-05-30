package com.devdad.ecommerce.mapper;

import com.devdad.ecommerce.dto.customer.CustomerRequestDTO;
import com.devdad.ecommerce.dto.customer.CustomerResponseDTO;
import com.devdad.ecommerce.model.Customer;

/**
 * CustomerMapper
 */
public class CustomerMapper {

	public static CustomerRequestDTO toRequestDTO(Customer customer) {
		return null;
	}

	public static CustomerResponseDTO toResponseDTO(Customer customer) {
		if (customer == null) {
			return null;
		}

		return new CustomerResponseDTO(
				customer.getId().toString(),
				customer.getFirstName(),
				customer.getLastName(),
				customer.getEmail(),
				customer.getAddress());
	}

	public static Customer toEntity(CustomerRequestDTO customer) {

		// TODO: Improve message
		if (customer == null) {
			return null;
		}

		return Customer.builder()
				.id(customer.id())
				.firstName(customer.firstName())
				.lastName(customer.lastName())
				.email(customer.email())
				.address(customer.address())
				.build();
	}
}
