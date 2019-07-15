package ua.step.kino.services;

import ua.step.kino.entities.User;
import ua.step.kino.entities.VerificationToken;
import validation.EmailExistsException;
import validation.LoginExistsException;
import validation.UserDto;

public interface RegistrationService {

	 User registerNewUserAccount(UserDto accountDto)     
		      throws EmailExistsException, LoginExistsException;
	 
	 User getUser(String verificationToken);

	 void createVerificationToken(User user, String token);
	 
	 VerificationToken getVerificationToken(String VerificationToken);
}
