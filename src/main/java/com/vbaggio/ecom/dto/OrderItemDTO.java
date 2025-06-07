package com.vbaggio.ecom.dto;

public record OrderItemDTO(
		Long productId, 
		String name, 
		Double price, 
		Integer quantity,
		Double subtotal
) {
	
}
