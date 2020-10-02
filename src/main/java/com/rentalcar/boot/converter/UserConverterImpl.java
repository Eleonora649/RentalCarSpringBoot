package com.rentalcar.boot.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.rentalcar.boot.dto.UserDTO;
import com.rentalcar.boot.model.User;

@Component("userConverter")
public class UserConverterImpl implements UserConverter {

	@Override
	public User convert(UserDTO userDto) throws ParseException {
		User user = new User();
		Date date = new SimpleDateFormat("yyyy-MM-dd").parse(userDto.getDate());
		
		user.setIdUser(userDto.getId());
		user.setName(userDto.getName());
		user.setSurname(userDto.getSurname());
		user.setDateOfBirth(date);
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		
		return user;
	}

	@Override
	public List<User> convertAll(List<UserDTO> userDto) throws Exception {
		List<User> users = new ArrayList<User>();
		Iterator<UserDTO> userDtos = userDto.iterator();
		
		while(userDtos.hasNext()) {
			UserDTO result = userDtos.next();
			users.add(this.convert(result));
		}
		return users;
	}

	@Override
	public UserDTO reverseConvert(User user) {
		UserDTO userDto = new UserDTO();
		String date = new SimpleDateFormat("yyyy-MM-dd").format(user.getDateOfBirth());
		
		userDto.setName(user.getName());
		userDto.setSurname(user.getSurname());
		userDto.setDate(date);
		userDto.setEmail(user.getEmail());
		userDto.setPassword(user.getPassword());
		
		return userDto;
	}

	@Override
	public List<UserDTO> reverseConvertAll(List<User> users) {
		List<UserDTO> userDtos= new ArrayList<>();
		Iterator<User> user = users.iterator();
		
		while (user.hasNext()) {
			User result = user.next();
			userDtos.add(this.reverseConvert(result));
		}
		return userDtos;
	}

}