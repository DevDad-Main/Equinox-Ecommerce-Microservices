package com.devdad.ecommerce.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.devdad.ecommerce.dto.PaymentRequestDTO;

/**
 * PaymentClient
 */
@FeignClient(name = "payment-service", url = "${application.config.payment-url}")
public interface PaymentClient {


	@PostMapping
	Integer requestOrderPayment(@RequestBody PaymentRequestDTO request);
}
