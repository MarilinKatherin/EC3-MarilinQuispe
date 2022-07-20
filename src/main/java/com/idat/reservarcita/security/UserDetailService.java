package com.idat.reservarcita.security;

import java.util.ArrayList;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailService implements UserDetailsService{	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if("Marilin".equals(username)) {
		return new User("Marilin","abc",new ArrayList<>());
		}else
			throw new UsernameNotFoundException("Usuario no existe "+username);	
	}
}
