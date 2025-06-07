package com.vbaggio.ecom.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vbaggio.ecom.entitites.OrderItem;
import com.vbaggio.ecom.entitites.OrderItemPK;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK>{
	
}
