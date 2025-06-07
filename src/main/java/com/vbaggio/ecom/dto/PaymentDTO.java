package com.vbaggio.ecom.dto;

import java.time.Instant;

public record PaymentDTO(
		
		Long Id, 
		
		Instant moment
) {}
