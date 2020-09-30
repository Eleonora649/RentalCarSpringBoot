package com.rentalcar.boot.facade;

import java.text.ParseException;
import java.util.List;

import com.rentalcar.boot.dto.UserDTO;

public interface UserFacade {
		
	public List<UserDTO> getAllUsers();
	
	public UserDTO getUserDtoById(Long id);
	
	public UserDTO createUser(UserDTO userDto) throws Exception;
	
	public UserDTO updateUserDto(Long id, UserDTO userDto) throws ParseException;
	
	public void deleteUserDto(Long id);

}
