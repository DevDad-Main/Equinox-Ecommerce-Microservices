package com.devdad.ecommerce.model;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * Product
 */
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@Getter
@Setter
@Entity
public class Product {

	@Id
	@GeneratedValue
	private Integer id;

	private String name;
	private String description;
	private double availableQuantity;
	private BigDecimal price;
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;
}
