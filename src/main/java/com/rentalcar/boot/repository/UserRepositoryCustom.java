package com.rentalcar.boot.repository;

import org.springframework.stereotype.Component;

import com.rentalcar.boot.model.User;

@Component
public interface UserRepositoryCustom {
	
	User findByEmail(String email);
}
