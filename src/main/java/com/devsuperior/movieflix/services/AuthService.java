package com.devsuperior.movieflix.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.movieflix.entities.User;
import com.devsuperior.movieflix.repositories.UserRepository;
import com.devsuperior.movieflix.services.exceptions.ForbiddenException;
import com.devsuperior.movieflix.services.exceptions.UnauthorizedException;

@Service
public class AuthService {

	
	@Autowired
	private UserRepository userRepository;
	
	@Transactional(readOnly = true)
	public User Autenticated() {
		
		try {
			String userName = SecurityContextHolder.getContext().getAuthentication().getName();
			return userRepository.findByEmail(userName);
		}catch (Exception e ) {
			throw new UnauthorizedException("Invalid User");
		}
		
	}
	
	public void validateSelfOrAdmin(Long userId) {
		
		User user = Autenticated();
		
		if (!user.getId().equals(userId) && !user.hasHole("ROLE_ADMIN")) {
			
			throw new ForbiddenException("Acess Dinied");
		
		}

	}
	
	public User getUserAutenticated() {
		
		User user = Autenticated();
		
		return user;

	}
	
}
