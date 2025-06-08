package com.vbaggio.ecom.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import com.vbaggio.ecom.dto.CategoryDTO;
import com.vbaggio.ecom.entitites.Category;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategoryMapper {
	
	CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);
	
	CategoryDTO toDto(Category category);
}
