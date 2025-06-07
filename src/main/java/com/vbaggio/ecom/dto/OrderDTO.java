package com.vbaggio.ecom.dto;

import java.time.Instant;
import java.util.List;

import com.vbaggio.ecom.entitites.OrderStatus;

public record OrderDTO(
		Long id,
		Instant moment,
		OrderStatus status,
		UserMinDTO client,
		PaymentDTO payment,
		List<OrderItemDTO> items,
		Double total
) {	
	
}
