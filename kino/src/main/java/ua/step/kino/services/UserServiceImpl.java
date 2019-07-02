package ua.step.kino.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ua.step.kino.entities.User;
import ua.step.kino.repositories.UsersRepository;

@Component
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UsersRepository userRepo;

	@Override
	public User getUserByLogin(String login) {
		return userRepo.findByLogin(login);
	}

}
