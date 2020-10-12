package com.rentalcar.boot.converter;

import java.util.List;

import com.rentalcar.boot.dto.RoleDTO;
import com.rentalcar.boot.model.Role;

public interface RoleConverter {

	Role convert(RoleDTO roleDto);
	
	List<Role> convertAll(List<RoleDTO> roleDto);
	
	RoleDTO reverseConvert(Role role);
	
	List<RoleDTO> reverseConvertAll(List<Role> role);
}
