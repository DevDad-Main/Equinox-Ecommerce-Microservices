package com.devdad.ecommerce.kafka;

import java.time.LocalDateTime;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import com.devdad.ecommerce.model.Notification;
import com.devdad.ecommerce.model.NotificationType;
import com.devdad.ecommerce.kafka.payment.PaymentConfirmation;
import com.devdad.ecommerce.kafka.order.OrderConfirmation;
import com.devdad.ecommerce.repository.NotificationRepository;

import jakarta.mail.MessagingException;

import com.devdad.ecommerce.email.EmailService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * NotificationConsumer
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationConsumer {

	private final NotificationRepository notificationRepository;
	private final EmailService emailService;

	@KafkaListener(topics = "payment-topic")
	public void consumePaymentSuccessNotification(
			PaymentConfirmation paymentConfirmation) throws MessagingException {
		log.info(String.format("[TOPIC] Consuming message from payment-topic:: %s", paymentConfirmation));

		notificationRepository.save(
				Notification.builder()
						.type(NotificationType.PAYMENT_CONFIRMATION)
						.notificationDate(LocalDateTime.now())
						.paymentConfirmation(paymentConfirmation)
						.build());

		var customerName = paymentConfirmation.customerFirstname() + " " + paymentConfirmation.customerLastname();

		emailService.sendPaymentSuccessEmail(
				paymentConfirmation.customerEmail(),
				customerName,
				paymentConfirmation.amount(),
				paymentConfirmation.orderReference());
	}

	@KafkaListener(topics = "order-topic")
	public void consumeOrderConfirmationNotification(
			OrderConfirmation orderConfirmation) throws MessagingException {
		log.info(String.format("[TOPIC] Consuming message from order-topic:: %s", orderConfirmation));

		notificationRepository.save(
				Notification.builder()
						.type(NotificationType.ORDER_CONFIRMATION)
						.notificationDate(LocalDateTime.now())
						.orderConfirmation(orderConfirmation)
						.build());

		var customerName = orderConfirmation.customer().firstName() + " " + orderConfirmation.customer().lastName();

		emailService.sendOrderConfirmationEmail(
				orderConfirmation.customer().email(),
				customerName,
				orderConfirmation.totalAmount(),
				orderConfirmation.orderReference(),
				orderConfirmation.products());
	}
}
