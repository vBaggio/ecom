package com.vbaggio.ecom.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.vbaggio.ecom.entitites.User;
import com.vbaggio.ecom.repositories.UserRepository;

import jakarta.persistence.EntityManager;

@Service
public class UserService implements UserDetailsService {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private EntityManager entityManager;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByEmailWithRoles(username)
			    				.orElseThrow(() -> new UsernameNotFoundException("Email not found: " + username));

		entityManager.detach(user);

		return user;
	}
}
