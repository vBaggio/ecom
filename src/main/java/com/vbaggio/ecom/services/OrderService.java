package com.vbaggio.ecom.services;

import java.time.Instant;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vbaggio.ecom.dto.OrderDTO;
import com.vbaggio.ecom.entitites.Order;
import com.vbaggio.ecom.entitites.OrderItem;
import com.vbaggio.ecom.entitites.OrderStatus;
import com.vbaggio.ecom.entitites.Product;
import com.vbaggio.ecom.mappers.OrderMapper;
import com.vbaggio.ecom.repositories.OrderItemRepository;
import com.vbaggio.ecom.repositories.OrderRepository;
import com.vbaggio.ecom.repositories.ProductRepository;
import com.vbaggio.ecom.services.exceptions.ResourceNotFoundException;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository repository;
	
	@Autowired
	private OrderItemRepository itemRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired 
	private UserService userService;
	
	@Autowired
	private AuthService authService;
	
	private void validateProducts(OrderDTO dto) {
	    Set<Long> productIds = dto.items().stream().map(x -> x.productId()).collect(Collectors.toSet());
	    List<Product> products = productRepository.findAllById(productIds);
	    if (productIds.size() != products.size()) {
	        throw new ResourceNotFoundException("One or more products not found");
	    }
	}

	private Order createOrder(OrderDTO dto) {
	    Order order = new Order();
	    order.setStatus(OrderStatus.WAITING_PAYMENT);
	    order.setMoment(Instant.now());
	    order.setClient(userService.authenticatedUser());

	    dto.items().forEach(x -> {
	        Product product = productRepository.getReferenceById(x.productId());
	        OrderItem item = new OrderItem(order, product, x.quantity(), product.getPrice());
	        order.getItems().add(item);
	    });

	    return order;
	}
	
	@Transactional(readOnly = true)
	public OrderDTO findById(Long id) {
		Order entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Order not found with id " + id));
		
		authService.validateSelfOrAdmin(entity.getClient().getId());
		
		return OrderMapper.INSTANCE.toDto(entity);
	}
	
	@Transactional
	public OrderDTO insert(OrderDTO dto) {
		validateProducts(dto);
	    
		Order order = createOrder(dto);
	    
		repository.save(order);
	    itemRepository.saveAll(order.getItems());

	    return OrderMapper.INSTANCE.toDto(order);
	}
}
