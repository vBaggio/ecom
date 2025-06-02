package com.vbaggio.ecom.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.vbaggio.ecom.entitites.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
	
	@Query("SELECT obj FROM Order obj JOIN FETCH obj.client JOIN FETCH obj.payment")
	List<Order> findAllWithClientMin();
}
