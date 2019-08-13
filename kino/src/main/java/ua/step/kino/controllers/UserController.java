package ua.step.kino.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ua.step.kino.entities.User;
import ua.step.kino.repositories.UsersRepository;
import ua.step.kino.security.CurrentUser;
import ua.step.kino.services.UserService;

@Controller
@RequestMapping("/users")
public class UserController {
	@Autowired
	UsersRepository usersRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private UserService userService;
	
	@Autowired
	private UsersRepository userRepo;
	
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
		model.addAttribute("user", user);
		return "userprofile";
	}
	
	@GetMapping(value = "/changePassword")
	public String showChangePassword(Model model,  @RequestParam Optional<String> error) {
		
		
		return "changePassword";
	}
	
	@PostMapping(value = "/changePassword")
	public String registerUserAccount(Model model, @RequestParam Optional<String> error, String password, String oldpassword) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		User user;
		CurrentUser currentUser = (CurrentUser) (principal);
		user = currentUser.getUser();
		if(!passwordEncoder.matches(oldpassword, user.getPassword())) {
			model.addAttribute("error", "Wrong old password!");
			return "changePassword";
		}
	
		String updatedPassword = passwordEncoder.encode(password);
		userService.updatePassword(updatedPassword, user.getId());
		model.addAttribute("user", user);
		return "userprofile";
	}
}
