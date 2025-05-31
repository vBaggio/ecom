package com.vbaggio.ecom.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vbaggio.ecom.dto.ProductDTO;
import com.vbaggio.ecom.entitites.Product;
import com.vbaggio.ecom.mappers.ProductMapper;
import com.vbaggio.ecom.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;

	@Transactional(readOnly = true)
	public ProductDTO findById(Long id) {
		Product product = repository.findById(id).get();
		ProductDTO dto = ProductMapper.INSTANCE.toDto(product);
		return dto;
	}

}
