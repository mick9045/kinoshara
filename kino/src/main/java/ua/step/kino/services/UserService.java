package ua.step.kino.services;

import ua.step.kino.entities.User;

public interface UserService {
	User getUserByLogin(String login);
}
