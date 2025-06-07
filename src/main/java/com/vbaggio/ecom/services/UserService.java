package com.vbaggio.ecom.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vbaggio.ecom.dto.UserDTO;
import com.vbaggio.ecom.entitites.User;
import com.vbaggio.ecom.mappers.UserMapper;
import com.vbaggio.ecom.repositories.UserRepository;

import jakarta.persistence.EntityManager;

@Service
public class UserService implements UserDetailsService {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private EntityManager entityManager;

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByEmailWithRoles(username)
				.orElseThrow(() -> new UsernameNotFoundException("Email not found: " + username));

		entityManager.detach(user);

		return user;
	}
	
	@Transactional(readOnly = true)
	protected User authenticatedUser() {
		try {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			Jwt jwtPrincipal = (Jwt) authentication.getPrincipal();
			String username = jwtPrincipal.getClaim("username");

			return (User) loadUserByUsername(username);	
		} catch (Exception e) {
			throw new UsernameNotFoundException("User not authenticated");
		}

	}
	
	@Transactional(readOnly = true)
	public UserDTO getMe() {
		return UserMapper.INSTANCE.toDto(authenticatedUser());
	}
	
}
