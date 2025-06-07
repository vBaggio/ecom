package com.vbaggio.ecom.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.vbaggio.ecom.dto.ProductDTO;
import com.vbaggio.ecom.dto.ProductMinDTO;
import com.vbaggio.ecom.entitites.Product;
import com.vbaggio.ecom.mappers.ProductMapper;
import com.vbaggio.ecom.repositories.ProductRepository;
import com.vbaggio.ecom.services.exceptions.DatabaseException;
import com.vbaggio.ecom.services.exceptions.ResourceNotFoundException;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;

	private Product entityFromId(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product not found with id " + id));
	}

	@Transactional(readOnly = true)
	public ProductDTO findById(Long id) {
		Product result = entityFromId(id);
		return ProductMapper.INSTANCE.toDto(result);
	}

	@Transactional(readOnly = true)
	public Page<ProductMinDTO> findAll(String name, Pageable pageable) {
		Page<Product> result = repository.searchByName(name, pageable);
		return result.map(x -> ProductMapper.INSTANCE.toMinDto(x));
	}

	@Transactional
	public ProductDTO insert(ProductDTO dto) {
		Product entity = ProductMapper.INSTANCE.toEntity(dto);
		entity = repository.save(entity);
		return ProductMapper.INSTANCE.toDto(entity);
	}

	@Transactional
	public ProductDTO update(Long id, ProductDTO dto) {
		Product entity = entityFromId(id);
		ProductMapper.INSTANCE.updateEntityFromDTO(dto, entity);
		entity = repository.save(entity);
		return ProductMapper.INSTANCE.toDto(entity);
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	public void delete(Long id) {
		if (!repository.existsById(id)) {
			throw new ResourceNotFoundException("Product not found with id " + id);
		}
		try {
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException();
		}
		
	}

}
