package com.vbaggio.ecom.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.data.web.config.EnableSpringDataWebSupport.PageSerializationMode;

@Configuration
@EnableSpringDataWebSupport(pageSerializationMode = PageSerializationMode.VIA_DTO)
public class WebConfig {
	// This class is used to configure Spring Data Web support, enabling pagination and sorting
	// with DTO serialization mode. It can be extended in the future for additional configurations.	
}
