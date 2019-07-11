package ua.step.kino.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import ua.step.kino.entities.User;
import ua.step.kino.repositories.RolesRepository;
import ua.step.kino.repositories.UsersRepository;
import ua.step.kino.validation.EmailExistsException;
import ua.step.kino.validation.LoginExistsException;
import ua.step.kino.validation.UserDto;

@Component("RegistrationService")
public class RegistrationServiceImpl implements RegistrationService {

	@Autowired
	private UsersRepository userRepo;
	@Autowired
	private RolesRepository rolesRepo;
	@Autowired
	private PasswordEncoder encoder;

	@Transactional
	@Override
	public User registerNewUserAccount(UserDto accountDto) throws EmailExistsException, LoginExistsException {

		if (emailExists(accountDto.getEmail())) {
			throw new EmailExistsException();
		}
		if (loginExists(accountDto.getLogin())) {
			throw new LoginExistsException();
		}
		System.out.println(accountDto.getLogin());
		User user = new User();
		user.setPassword(encoder.encode(accountDto.getPassword()));
		user.setLogin(accountDto.getLogin());
		user.setName(accountDto.getLogin());
		user.setEmail(accountDto.getEmail());
		user.setBirthday(accountDto.getBirthday());
		user.setRole(rolesRepo.getOne(1));
		return userRepo.save(user);
	}

	private boolean emailExists(String email) {
		User user = userRepo.findByEmail(email);
		if (user != null) {
			return true;
		}
		return false;
	}

	private boolean loginExists(String login) {
		User user = userRepo.findByLogin(login);
		if (user != null) {
			return true;
		}
		return false;
	}

}
