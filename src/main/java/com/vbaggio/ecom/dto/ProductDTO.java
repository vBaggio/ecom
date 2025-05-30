package com.vbaggio.ecom.dto;

public record ProductDTO(
		
		Long id, 
		
		String name, 
		
		String description, 
		
		Double price, 
		
		String imgUrl
) {}
