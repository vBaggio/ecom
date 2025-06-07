package com.vbaggio.ecom.dto;

public record ProductMinDTO(
		Long id,
		String name,
		Double price,
		String imgUrl
) {}
