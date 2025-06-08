package com.vbaggio.ecom.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vbaggio.ecom.dto.CategoryDTO;
import com.vbaggio.ecom.mappers.CategoryMapper;
import com.vbaggio.ecom.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repository;

	@Transactional(readOnly = true)
	public List<CategoryDTO> findAll() {
		return repository.findAll()
				.stream().map(CategoryMapper.INSTANCE::toDto)
				.collect(Collectors.toList());
	}

}
