package com.devdad.ecommerce.producer;

import org.springframework.messaging.Message;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.devdad.ecommerce.dto.PaymentNotificationRequestDTO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * NotificationProducer
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationProducer {

	private final KafkaTemplate<String, PaymentNotificationRequestDTO> kafkaTemplate;

	public void sendNotification(PaymentNotificationRequestDTO request)
	{
		log.info("Sending notificaiton with body <{}>", request);

		Message<PaymentNotificationRequestDTO> message = MessageBuilder
			.withPayload(request)
			.setHeader(KafkaHeaders.TOPIC, "payment-topic")
			.build();

		kafkaTemplate.send(message);
	}
}
