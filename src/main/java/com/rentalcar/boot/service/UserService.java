package com.rentalcar.boot.service;

import java.util.List;
import java.util.Optional;

import com.rentalcar.boot.model.User;

public interface UserService {
	
	public List<User> getAllUsers();
	
	public Optional<User> getUserById(long id);
	
	public void addUser(User user);
	
	public void updateUser(int id, User user);
	
	public void deleteUser(long id);
}
