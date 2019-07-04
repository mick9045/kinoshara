package ua.step.kino.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ua.step.kino.entities.User;
import ua.step.kino.repositories.UsersRepository;
import ua.step.kino.security.UserDetailsServiceImpl;

@Component
public class UserServiceImpl implements UserService {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UsersRepository userRepo;

	@Override
	public User getUserByLogin(String login) {
		LOGGER.info("debug" + login);
		return userRepo.findByLogin(login);
	}

}
