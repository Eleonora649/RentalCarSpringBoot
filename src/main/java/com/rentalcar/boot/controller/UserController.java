package com.rentalcar.boot.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rentalcar.boot.dto.UserDTO;
import com.rentalcar.boot.facade.UserFacade;

@RestController
@RequestMapping(value="/users")
public class UserController {
	
	@Autowired
	private UserFacade userFacade;
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/list-customers")	
	public List<UserDTO> getAllUsers() {
		return userFacade.getAllUsers();
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/list-customers/{id}") 
	public ResponseEntity<UserDTO> getUserById(@PathVariable(value = "id") Long id) {
		UserDTO user = userFacade.getUserDtoById(id);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	@PostMapping("/register")
	public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO userDto) {
		UserDTO user = null;
		try {
			user = userFacade.createUser(userDto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(user, HttpStatus.CREATED);
	}
	
	@PreAuthorize("hasRole('CUSTOMER')")
	@PutMapping
	public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userDto) {
		try {
			Long id = userDto.getId();
			userFacade.updateUserDto(id, userDto);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (ParseException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
	
	@PreAuthorize("hasRole('ADMIN') || hasRole('CUSTOMER')")
	@DeleteMapping("/delete-customers/{id}")
	public ResponseEntity<HttpStatus> deleteUser(@PathVariable Long id) {
		userFacade.deleteUserDto(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}