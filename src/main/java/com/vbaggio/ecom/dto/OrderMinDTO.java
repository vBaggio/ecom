package com.vbaggio.ecom.dto;

public record OrderMinDTO(
		Long id,
		String moment,
		String status,
		UserMinDTO client
) {}