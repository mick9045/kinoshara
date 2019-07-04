package ua.step.kino.services;

import ua.step.kino.entities.User;
import validation.EmailExistsException;
import validation.LoginExistsException;
import validation.UserDto;

public interface RegistrationService {

	 User registerNewUserAccount(UserDto accountDto)     
		      throws EmailExistsException, LoginExistsException;

}
