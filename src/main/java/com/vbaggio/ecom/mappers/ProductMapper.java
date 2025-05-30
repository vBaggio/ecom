package com.vbaggio.ecom.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.vbaggio.ecom.dto.ProductDTO;
import com.vbaggio.ecom.entitites.Product;

@Mapper
public interface ProductMapper {

	ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);
	
	ProductDTO toDto(Product product);
}
