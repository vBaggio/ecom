package com.vbaggio.ecom.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
		Product result = repository.findById(id).get();
		return ProductMapper.INSTANCE.toDto(result);
	}

	@Transactional(readOnly = true)
	public Page<ProductDTO> findAll(Pageable pageable) {
		Page<Product> result = repository.findAll(pageable);
		return result.map(x -> ProductMapper.INSTANCE.toDto(x));
	}

	@Transactional
	public ProductDTO insert(ProductDTO dto) {
		Product entity = ProductMapper.INSTANCE.toEntity(dto);
		entity = repository.save(entity);
		return ProductMapper.INSTANCE.toDto(entity);
	}

	@Transactional
	public ProductDTO update(Long id, ProductDTO dto) {
		Product entity = repository.findById(id).get();
		ProductMapper.INSTANCE.updateEntityFromDTO(dto, entity);
		entity = repository.save(entity);
		return ProductMapper.INSTANCE.toDto(entity);
	}

	@Transactional
	public void delete(Long id) {
		repository.deleteById(id);
	}

}
