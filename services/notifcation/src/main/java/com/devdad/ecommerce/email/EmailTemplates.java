package com.devdad.ecommerce.email;

import lombok.Getter;

/**
 * EmailTemplates
 */
public enum EmailTemplates {

	PAYMENT_CONFIRMATION("payment-confirmation.html", "Payment Successfully Processed"),
	ORDER_CONFIRMATION("order-confirmation.html", "Order Confirmation");

	@Getter
	private final String template;

	@Getter
	private final String subject;

	EmailTemplates(String template, String subject) {
		this.template = template;
		this.subject = subject;
	}

}
