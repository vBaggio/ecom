package com.vbaggio.ecom.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.vbaggio.ecom.dto.OrderMinDTO;
import com.vbaggio.ecom.entitites.Order;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderMapper {

	OrderMapper INSTANCE = org.mapstruct.factory.Mappers.getMapper(OrderMapper.class);
	
	OrderMinDTO toMinDto(Order order);
}
