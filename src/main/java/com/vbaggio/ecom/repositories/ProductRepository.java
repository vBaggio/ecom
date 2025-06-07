package com.vbaggio.ecom.repositories;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.vbaggio.ecom.entitites.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	
	@Query("SELECT p FROM Product p WHERE UPPER(p.name) LIKE UPPER(CONCAT('%', :name, '%'))")
	Page<Product> searchByName(String name, Pageable pageable);
	
	@Query("SELECT p FROM Product p JOIN FETCH p.categories WHERE p.id = :id")
	Optional<Product> findByIdWithCategories(Long id);
}
