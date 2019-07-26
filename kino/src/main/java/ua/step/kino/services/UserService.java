package ua.step.kino.services;

import ua.step.kino.entities.User;
import validation.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService  {
	User getUserByLogin(String login);
	
	User findByEmail(String email);
	
	User save(UserDto registration);
   
	void updatePassword(String password, int userId);
}
