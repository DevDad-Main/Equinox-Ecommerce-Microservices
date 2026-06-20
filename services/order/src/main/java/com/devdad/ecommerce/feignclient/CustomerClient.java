package com.devdad.ecommerce.feignclient;

import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.devdad.ecommerce.dto.CustomerResponseDTO;

/**
 * CustomerClient
 */
@FeignClient(name = "customer-service", url = "${application.config.customer-url}")
public interface CustomerClient {

	@GetMapping("/${customer-id}")
	Optional<CustomerResponseDTO> findCustomerById(@PathVariable("customer-id") String customerId);

}
