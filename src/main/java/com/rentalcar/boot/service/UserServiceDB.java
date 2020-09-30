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
	public User updateUser(Long id, User user) {

		if(user.equals(getUserById(id))) {
			user.setName(user.getName());
			user.setSurname(user.getSurname());
			user.setDateOfBirth(user.getDateOfBirth());
			user.setEmail(user.getEmail());
			user.setPassword(user.getPassword());
        }
		return user = userRepository.save(user);
	}

	@Override
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}

}
