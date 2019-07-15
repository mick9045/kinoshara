package ua.step.kino.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import ua.step.kino.entities.User;
import ua.step.kino.entities.VerificationToken;
import ua.step.kino.repositories.RolesRepository;
import ua.step.kino.repositories.UsersRepository;
import ua.step.kino.repositories.VerificationTokenRepository;
import validation.EmailExistsException;
import validation.LoginExistsException;
import validation.UserDto;

@Component("RegistrationService")
public class RegistrationServiceImpl implements RegistrationService {

	@Autowired
	private UsersRepository userRepo;
	@Autowired
	private RolesRepository rolesRepo;
	@Autowired
	private PasswordEncoder encoder;
	@Autowired
	private VerificationTokenRepository tokenRepository;

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

	@Override
	public User getUser(String verificationToken) {
		User user = tokenRepository.findByToken(verificationToken).getUser();
        return user;
	}

	@Override
	public void createVerificationToken(User user, String token) {
		VerificationToken myToken = new VerificationToken(token, user);
        tokenRepository.save(myToken);		
	}

	@Override
	public VerificationToken getVerificationToken(String VerificationToken) {
		return tokenRepository.findByToken(VerificationToken);
	}

}
