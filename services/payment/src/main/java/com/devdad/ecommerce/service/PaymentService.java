package com.devdad.ecommerce.service;

import org.springframework.stereotype.Service;

import com.devdad.ecommerce.producer.NotificationProducer;
import com.devdad.ecommerce.dto.PaymentNotificationRequestDTO;
import com.devdad.ecommerce.dto.PaymentRequestDTO;
import com.devdad.ecommerce.mapper.PaymentMapper;
import com.devdad.ecommerce.repository.PaymentRepository;

import lombok.RequiredArgsConstructor;

/**
 * PaymentService
 */
@Service
@RequiredArgsConstructor
public class PaymentService {

	private final PaymentRepository paymentRepository;
	private final NotificationProducer notificiationProducer;

	public Integer createPayment(PaymentRequestDTO request) {
		var payment = paymentRepository.save(PaymentMapper.toEntity(request));

		notificiationProducer.sendNotification(
				new PaymentNotificationRequestDTO(
						request.orderReference(),
						request.amount(),
						request.paymentMethod(),
						request.customer().firstName(),
						request.customer().lastName(),
						request.customer().email()));

		return payment.getId();
	}
}
