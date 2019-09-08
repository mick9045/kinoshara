package ua.step.kino.services;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import ua.step.kino.entities.User;
import ua.step.kino.repositories.RolesRepository;
import ua.step.kino.repositories.UsersRepository;
import validation.UserDto;

@Component
public class UserServiceImpl implements UserService {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UsersRepository userRepository;
	@Autowired
	private UserService userService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private RolesRepository rolesRepository;

	@Override
	public User getUserByLogin(String login) {
		LOGGER.info("debug" + login);
		return userRepository.findByLogin(login);
	}

	public User findByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public User save(UserDto registration){
        User user = new User();
        user.setPassword(passwordEncoder.encode(registration.getPassword()));
		user.setLogin(registration.getLogin());
		user.setName(registration.getLogin());
		user.setEmail(registration.getEmail());
		user.setBirthday(registration.getBirthday());
		user.setRole(rolesRepository.getOne(1));
		return userRepository.save(user);
	  }
    
    @Transactional
    @Override
	public void updatePassword(String password, int userId) {
		  userRepository.updatePassword(password, userId);
	}
    
    @Transactional
	@Override
	public void updateAvatar(String imageName, int userId) {
    	 userRepository.updateAvatar(imageName, userId);
		
	}

     /*  @Override
	public CurrentUser loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userService.getUserByLogin(username);
		if (user == null) {
			throw new UsernameNotFoundException("Name not found: " + username);
		}
		return new CurrentUser(user);
	}*/

	
	
	
	 
}
