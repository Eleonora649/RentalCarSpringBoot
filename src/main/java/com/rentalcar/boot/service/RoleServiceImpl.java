package com.rentalcar.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rentalcar.boot.model.Role;
import com.rentalcar.boot.repository.RoleRepository;

@Service("roleService")
public class RoleServiceImpl implements RoleService{

	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public void addRole(Role role) {
		roleRepository.save(role);
	}

	@Override
	public List<Role> getList() {
		return roleRepository.findAll();
	}

	@Override
	public Role findRoleById(int idRole) {
		return roleRepository.getOne(idRole);
	}

	@Override
	public Role findRoleByName(String name) {
		return roleRepository.findByName(name);
	}

}
