package ua.step.kino.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import ua.step.kino.entities.User;
import ua.step.kino.services.UserService;

public class UserDetailsServiceImpl implements UserDetailsService {

	private final UserService userService;
	
	@Autowired
	public UserDetailsServiceImpl(UserService userService) {
		this.userService = userService;
	}

	@Override
	public CurrentUser loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userService.getUserByLogin(username);
		return new CurrentUser(user);
	}
	
	

}
