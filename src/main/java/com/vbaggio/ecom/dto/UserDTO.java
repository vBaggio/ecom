package com.vbaggio.ecom.dto;

import java.util.List;

public record UserDTO(
		Long id, 
		String name, 
		String email, 
		String phone,
		String birthDate,
		List<String> roles
) {}
