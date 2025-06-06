package com.vbaggio.ecom.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.vbaggio.ecom.entitites.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	@Query("SELECT u FROM User u JOIN FETCH u.roles WHERE u.email = :email")
	Optional<User> findByEmailWithRoles(String email);

}
