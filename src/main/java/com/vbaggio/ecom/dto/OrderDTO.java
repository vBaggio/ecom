package com.vbaggio.ecom.dto;

import java.time.Instant;
import java.util.List;

import com.vbaggio.ecom.entitites.OrderStatus;

import jakarta.validation.constraints.NotEmpty;

public record OrderDTO(
		Long id,
		Instant moment,
		OrderStatus status,
		UserMinDTO client,
		PaymentDTO payment,
		@NotEmpty(message = "{NotEmpty}")
		List<OrderItemDTO> items,
		Double total
) {	
	
}
