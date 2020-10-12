package com.rentalcar.boot.service;

import java.util.List;

import com.rentalcar.boot.model.Role;

public interface RoleService {

	void addRole(Role role);
	
	List<Role> getList();
	
	Role findRoleById(int idRole);
	
	Role findRoleByName(String name);
}
