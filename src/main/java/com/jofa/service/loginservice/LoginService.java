package com.jofa.service.loginservice;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jofa.model.User;
import com.jofa.service.UserService;

@Service("loginService")
public class LoginService implements UserDetailsService
{

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
	{
		User user = null;
		try
		{
			user = UserService.findByUsername(username);
		} catch (IOException e1)
		{
			e1.printStackTrace();
		}
		if (user == null) {
			UsernameNotFoundException e = new UsernameNotFoundException("User not found");
			throw e;
		}
		
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(user.getUserRoles());
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), true,
				true, true, true, authorities);
	}

}
