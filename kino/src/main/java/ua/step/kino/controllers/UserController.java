package ua.step.kino.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.step.kino.entities.User;
import ua.step.kino.repositories.UsersRepository;
import ua.step.kino.security.CurrentUser;

@Controller
@RequestMapping("/users")
public class UserController {
	@Autowired
	UsersRepository usersRepository;
	

	@GetMapping
	public String showAll(Model model) {
		List<User> users = usersRepository.findAll();
		model.addAttribute("users", users);
		return "users";
	}

	/**
	 * @author AZavoruyev
	 */
	@GetMapping("/user")
	public String showUserProfile(Model model) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		User user;
		CurrentUser currentUser = (CurrentUser) (principal);
		user = currentUser.getUser();
		System.out.println(user.getFirstName()+" "+ user.getLastName()+" "+user.getPassword());
		model.addAttribute("user", user);
		return "userprofile";
	}

}
