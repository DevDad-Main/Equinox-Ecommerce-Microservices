package com.devdad.ecommerce.service;

import static java.lang.String.format;

import java.util.List;

import org.springframework.stereotype.Service;
import com.devdad.ecommerce.repository.CustomerRepository;

import io.micrometer.common.util.StringUtils;

import com.devdad.ecommerce.dto.customer.CustomerRequestDTO;
import com.devdad.ecommerce.dto.customer.CustomerResponseDTO;
import com.devdad.ecommerce.exception.CustomerNotFoundException;
import com.devdad.ecommerce.mapper.CustomerMapper;
import com.devdad.ecommerce.model.Customer;

import lombok.RequiredArgsConstructor;

/**
 * CustomerService
 */
@Service
@RequiredArgsConstructor
public class CustomerService {

	private final CustomerRepository repository;

	public String createCustomer(CustomerRequestDTO request) {
		return repository.save(CustomerMapper.toEntity(request)).getId().toString();
	}

	public List<CustomerResponseDTO> findAllCustomers() {
		return repository.findAll().stream().map(CustomerMapper::toResponseDTO).toList();
	}

	public void updateCustomer(CustomerRequestDTO request) {
		var customer = repository
				.findById(request.id())
				.orElseThrow(() -> new CustomerNotFoundException(
						format("Cannot update customer:: No customer found with the provided ID:: %s", request.id())));

		mergeCustomer(customer, request);
		repository.save(customer);
	}

	public Boolean existsById(String customerId) {
		return repository
				.findById(customerId)
				.isPresent();
	}

	public CustomerResponseDTO findById(String customerId) {
		return repository.findById(customerId)
				.map(CustomerMapper::toResponseDTO)
				.orElseThrow(() -> new CustomerNotFoundException(
						format("No Cusomter found with the provided ID:: %s", customerId)));
	}

	public void deleteCustomer(String customerId) {
		repository.deleteById(customerId);
	}

	private void mergeCustomer(Customer customer, CustomerRequestDTO request) {
		if (StringUtils.isNotBlank(request.firstName())) {
			customer.setFirstName(request.firstName());
		}

		if (StringUtils.isNotBlank(request.lastName())) {
			customer.setLastName(request.lastName());
		}

		if (StringUtils.isNotBlank(request.email())) {
			customer.setEmail(request.email());
		}

		if (request.address() != null) {
			customer.setAddress(request.address());
		}
	}

}
