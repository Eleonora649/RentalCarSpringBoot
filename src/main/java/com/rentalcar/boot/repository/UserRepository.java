package com.rentalcar.boot.repository;

import org.springframework.stereotype.Repository;

import com.rentalcar.boot.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long>, UserRepositoryCustom {
	
}
