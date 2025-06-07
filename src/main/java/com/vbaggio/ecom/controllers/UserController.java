package com.vbaggio.ecom.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vbaggio.ecom.dto.UserDTO;
import com.vbaggio.ecom.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserController {
	
	@Autowired
	UserService userService;
	
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_CLIENT')")
	@GetMapping(value = "/me")
	public ResponseEntity<UserDTO> getMe() {
		return ResponseEntity.ok(userService.getMe());
	}

}
