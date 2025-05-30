package com.vbaggio.ecom.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vbaggio.ecom.dto.ProductDTO;
import com.vbaggio.ecom.entitites.Product;
import com.vbaggio.ecom.mappers.ProductMapper;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ProductDTO> findById(@PathVariable Long id) {
		Product product = new Product(1L, "Produto Teste", "Teste API Produto", 10.00, "https://teste.com/img.png");
		
		ProductDTO dto = ProductMapper.INSTANCE.toDto(product); 
		
		return ResponseEntity.ok(dto);
	}
}
