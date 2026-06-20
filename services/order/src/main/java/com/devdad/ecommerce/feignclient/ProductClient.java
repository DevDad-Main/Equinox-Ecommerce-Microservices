package com.devdad.ecommerce.feignclient;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.devdad.ecommerce.dto.PurchaseRequestDTO;
import com.devdad.ecommerce.dto.PurchaseResponseDTO;
import com.devdad.ecommerce.exception.BusinessException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductClient {

	@Value("${application.config.product-url}")
	private String productUrl;
	private final RestTemplate restTemplate;

	public List<PurchaseResponseDTO> purchaseProducts(List<PurchaseRequestDTO> requestBody) {
		HttpHeaders headers = new HttpHeaders();
		headers.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);

		HttpEntity<List<PurchaseRequestDTO>> requestEntity = 
			new HttpEntity<>(requestBody, headers);

		ParameterizedTypeReference<List<PurchaseResponseDTO>> responseType = 
			new ParameterizedTypeReference<List<PurchaseResponseDTO>>() {
		};

		ResponseEntity<List<PurchaseResponseDTO>> responseEntity = restTemplate.exchange(
				productUrl + "/purchase", 
				HttpMethod.POST, 
				requestEntity, 
				responseType);


		// NOTE: If the err is 4xx or 5xx status codes
		if(responseEntity.getStatusCode().isError()){
			throw new BusinessException("An error occured while processing the products purchase:: " + responseEntity.getStatusCode());
		}

		// NOTE: Contains the body of the repsonse or the actual body its self
		return responseEntity.getBody();

	}
}
