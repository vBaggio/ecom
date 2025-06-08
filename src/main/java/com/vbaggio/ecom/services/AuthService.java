package com.vbaggio.ecom.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.vbaggio.ecom.entitites.User;
import com.vbaggio.ecom.services.exceptions.ForbiddenException;

@Service
public class AuthService {
	
	@Autowired
	private UserService userService;
	
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public void validateSelfOrAdmin(Long userId) {
		User me = userService.authenticatedUser();
		
		if (!me.getId().equals(userId) && !me.hasRole("ROLE_ADMIN")) {
			throw new ForbiddenException("Access denied");
		}
	}
}
