package com.rentalcar.boot.service;

import java.util.List;

import com.rentalcar.boot.model.User;

public interface UserService {
	
	public List<User> getAllUsers();
	
	public User getUserById(Long id);
	
	public User createUser(User user);
	
	public User updateUser(User user);
	
	public void deleteUser(Long id);
}
