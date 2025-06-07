package com.vbaggio.ecom.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vbaggio.ecom.entitites.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
