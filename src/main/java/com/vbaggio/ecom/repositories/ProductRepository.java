package com.vbaggio.ecom.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vbaggio.ecom.entitites.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
}
