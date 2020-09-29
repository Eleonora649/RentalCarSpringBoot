package com.rentalcar.boot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.rentalcar.boot.model.User;
import com.rentalcar.boot.service.UserService;

@Controller(value="/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}
	
	@GetMapping(value = "/{id}") 
	public ResponseEntity<User> getUserById(@PathVariable(value = "id") int id) {
		Optional<User> user = userService.getUserById(id);
		return new ResponseEntity<>(user.get(), HttpStatus.OK);
	}
	
	@PostMapping
	public void addUser(@RequestBody User user) {
		userService.addUser(user);
	}
	
	@PutMapping(value = "/{id}")
	public void updateUser(@PathVariable(value="id") int id, @RequestBody User user) {
		userService.updateUser(id, user);
	}
	
	@DeleteMapping(value = "/{id}")
	public void deleteUser(@PathVariable int id) {
		userService.deleteUser(id);
	}
}
