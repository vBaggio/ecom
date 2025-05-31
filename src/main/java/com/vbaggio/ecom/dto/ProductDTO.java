package com.vbaggio.ecom.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record ProductDTO(
		
		Long id, 
			
		@Size(min = 3, max = 80, message = "must be 3 to 80 characters long")
		@NotBlank
		String name, 
		
		@Size(max = 120, message = "must have a maximum of 120 characters")
		String description, 
		
		@NotNull
		@Positive
		Double price, 
		
		String imgUrl
) {}
