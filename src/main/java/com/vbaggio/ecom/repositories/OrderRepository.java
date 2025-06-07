package com.vbaggio.ecom.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vbaggio.ecom.entitites.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
