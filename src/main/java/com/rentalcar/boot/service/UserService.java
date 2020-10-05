  
package com.rentalcar.boot.service;

import java.util.List;

import com.rentalcar.boot.model.User;

public interface UserService {
	
	List<User> getAllUsers();
	
	User getUserById(Long id);
	
	User createUser(User user);
	
	User updateUser(User user);
	
	void deleteUser(Long id);
}