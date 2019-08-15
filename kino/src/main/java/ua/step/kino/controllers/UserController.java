package ua.step.kino.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ua.step.kino.dto.FilmDTO;
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
	
	@PostMapping("/user")
//	@Transactional
	@Secured("ROLE_USER")
	String post(@Valid FilmDTO filmDTO, Model model, Errors errors, RedirectAttributes redir) {
		/*
		 * if (!errors.hasErrors() && addFilmService.add(filmDTO)) {
		 * redir.addFlashAttribute("result", "success"); } else {
		 * redir.addFlashAttribute("result", "fail"); }
		 */
		return "redirect:/admin/add/film";
	}
	
	
	@GetMapping(value = "/changePassword")
	public String showChangePassword(Model model,  @RequestParam Optional<String> error) {
		
		
		return "changePassword";
	}
	
	@PostMapping(value = "/changePassword")
	@Transactional
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
