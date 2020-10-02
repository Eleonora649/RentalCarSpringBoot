package com.rentalcar.boot.converter;

import java.text.ParseException;
import java.util.List;

import com.rentalcar.boot.dto.UserDTO;
import com.rentalcar.boot.model.User;

public interface UserConverter {

	User convert(UserDTO userDto) throws ParseException;
	
	List<User> convertAll(List<UserDTO> userDto) throws Exception;
	
	UserDTO reverseConvert(User user);
	
	List<UserDTO> reverseConvertAll(List<User> user);
}