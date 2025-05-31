package com.vbaggio.ecom.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import com.vbaggio.ecom.dto.ProductDTO;
import com.vbaggio.ecom.entitites.Product;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductMapper {

	ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);
	
	ProductDTO toDto(Product product);
	
	@Mapping(target = "id", ignore = true)
	Product toEntity(ProductDTO dto);
	
	@Mapping(target = "id", ignore = true)
	void updateEntityFromDTO(ProductDTO dto, @MappingTarget Product product);
}