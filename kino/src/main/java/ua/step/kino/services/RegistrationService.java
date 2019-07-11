package ua.step.kino.services;

import ua.step.kino.entities.User;
import ua.step.kino.validation.EmailExistsException;
import ua.step.kino.validation.LoginExistsException;
import ua.step.kino.validation.UserDto;

public interface RegistrationService {

	 User registerNewUserAccount(UserDto accountDto)     
		      throws EmailExistsException, LoginExistsException;

}
