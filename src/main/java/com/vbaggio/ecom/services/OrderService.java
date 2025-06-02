package com.vbaggio.ecom.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vbaggio.ecom.dto.OrderMinDTO;
import com.vbaggio.ecom.entitites.Order;
import com.vbaggio.ecom.mappers.OrderMapper;
import com.vbaggio.ecom.repositories.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository repository;
	
	public List<OrderMinDTO> findAll() {
		List<Order> orders = repository.findAllWithClientMin();
		return orders.stream()
				.map(OrderMapper.INSTANCE::toMinDto)
				.collect(Collectors.toList());
	}
}
