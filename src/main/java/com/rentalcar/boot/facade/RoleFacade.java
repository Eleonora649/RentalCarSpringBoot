package com.rentalcar.boot.facade;

import java.util.List;

import com.rentalcar.boot.dto.RoleDTO;

public interface RoleFacade {
	
	RoleDTO createRole(RoleDTO roleDto);
	
	List<RoleDTO> getList();
	
	RoleDTO findRoleById(int idRole);
	
	RoleDTO findRoleByName(String name);
}
