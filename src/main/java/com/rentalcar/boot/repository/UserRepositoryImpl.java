package com.rentalcar.boot.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.rentalcar.boot.model.User;

public class UserRepositoryImpl implements UserRepositoryCustom {

	@PersistenceContext
    private EntityManager entityManager;
	
	@Override
	public User findByEmail(String email) {
		User user = entityManager.
				createQuery("SELECT u FROM User u WHERE u.email=:email", User.class)
				.setParameter("email", email).getSingleResult();
		return user;
	}

}
