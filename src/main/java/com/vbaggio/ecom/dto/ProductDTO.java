package com.vbaggio.ecom.dto;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record ProductDTO(
		
		Long id, 
			
		@Size(min = 3, max = 80, message="{Size}")
		@NotBlank(message="{NotBlank}")
		String name, 
		
		@Size(min = 10, message="{SizeMin}")
		@NotBlank
		String description, 
		
		@NotNull(message="{NotNull}")
		@Positive(message="{Positive}")
		Double price, 
		
		String imgUrl,
		
		@NotEmpty(message="{NotEmpty}")
		List<CategoryDTO> categories
) {}
