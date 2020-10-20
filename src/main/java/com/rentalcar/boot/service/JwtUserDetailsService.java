package com.rentalcar.boot.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.rentalcar.boot.model.Role;
import com.rentalcar.boot.model.User;
import com.rentalcar.boot.repository.UserRepository;

@Service("userDetailsService")
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@SuppressWarnings("unused")
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(email);
		Collection<? extends GrantedAuthority> authorities = this.setUserAuthorities(user.getRoles());

		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + email);
		} else {
			return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorities);
		}
	}
	
	public Collection<? extends GrantedAuthority> setUserAuthorities(List<Role> auths) {
		List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
		for (Role auth : auths) {
			grantedAuthorities.add(new SimpleGrantedAuthority(auth.getNameRole().name())); 		
		}
		return grantedAuthorities;
	}
}