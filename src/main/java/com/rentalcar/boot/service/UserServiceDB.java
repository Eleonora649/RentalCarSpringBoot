package com.rentalcar.boot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rentalcar.boot.model.User;
import com.rentalcar.boot.repository.UserRepository;

@Service
public class UserServiceDB implements UserService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> getAllUsers() {
		return (List<User>) userRepository.findAll();
	}

	@Override
	public Optional<User> getUserById(long id) {
		return userRepository.findById(id);
	}

	@Override
	public void addUser(User user) {
		User u = new User();
		u.setName(u.getName());
	    u.setSurname(u.getSurname());
	    u.setDateOfBirth(u.getDateOfBirth());
	    u.setEmail(u.getEmail());
	    u.setPassword(u.getPassword());

    	userRepository.save(u);
	}

	@Override
	public void updateUser(int id, User user) {
		Optional<User> u = getUserById(id);
        
		if(u!=null) {
            u.get().setName(user.getName());
            u.get().setSurname(user.getSurname());
            u.get().setDateOfBirth(user.getDateOfBirth());
            u.get().setEmail(user.getEmail());
            u.get().setPassword(user.getPassword());
        }
		userRepository.save(u.get());
	}

	@Override
	public void deleteUser(long id) {
		userRepository.deleteById(id);
	}

}
