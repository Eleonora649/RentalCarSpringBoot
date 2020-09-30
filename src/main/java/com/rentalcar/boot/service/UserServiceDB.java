package com.rentalcar.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rentalcar.boot.model.User;
import com.rentalcar.boot.repository.UserRepository;

@Service("userService")
public class UserServiceDB implements UserService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> getAllUsers() {
		return (List<User>) userRepository.findAll();
	}

	@Override
	public User getUserById(Long id) {
		return userRepository.getOne(id);
	}

	@Override
	public User createUser(User user) {
		return user = userRepository.save(user);
	}

	@Override
	public User updateUser(User user) {
		User us = this.getUserById(user.getIdUser());
		
		if(user!=null && us!=null) {
			us.setName(user.getName());
			us.setSurname(user.getSurname());
			us.setDateOfBirth(user.getDateOfBirth());
			us.setEmail(user.getEmail());
			us.setPassword(user.getPassword());
		}
		return userRepository.save(us);
	}

	@Override
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}

}
