package com.vbaggio.ecom.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vbaggio.ecom.dto.OrderDTO;
import com.vbaggio.ecom.entitites.Order;
import com.vbaggio.ecom.mappers.OrderMapper;
import com.vbaggio.ecom.repositories.OrderRepository;
import com.vbaggio.ecom.services.exceptions.ResourceNotFoundException;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository repository;
	
	@Transactional(readOnly = true)
	public OrderDTO findById(Long id) {
		Order entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Order not found with id " + id));
		
		return OrderMapper.INSTANCE.toDto(entity);
	}
}
