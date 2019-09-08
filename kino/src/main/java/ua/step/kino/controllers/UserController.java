package ua.step.kino.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ua.step.kino.entities.Film;
import ua.step.kino.entities.User;
import ua.step.kino.entities.Users_Films;
import ua.step.kino.repositories.FilmRepository;
import ua.step.kino.repositories.UsersRepository;
import ua.step.kino.repositories.Users_FilmsRepository;
import ua.step.kino.security.CurrentUser;
import ua.step.kino.services.SimilarFilmsImpl;
import ua.step.kino.services.UploadService;
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
	FilmRepository filmsRepository;

	@Autowired
	UploadService uploadService;
	
	@Autowired
	Users_FilmsRepository users_FilmsRepository;
	
	@Autowired
	SimilarFilmsImpl similarFilmsService;

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
	public String showUserProfile(Model model, @RequestParam Optional<String> error) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		User user;
		CurrentUser currentUser = (CurrentUser) (principal);
		user = currentUser.getUser();
		model.addAttribute("user", user);
		return "userprofile";
	}

	@PostMapping("/user")
	@Transactional
	@Secured("ROLE_USER")
	String post(@Valid MultipartFile smallPortrait, Model model, @RequestParam Optional<String> error) {
		String imageName = "";
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		User user;
		CurrentUser currentUser = (CurrentUser) (principal);
		user = currentUser.getUser();
		if (smallPortrait.isEmpty()) {
			model.addAttribute("error", "You don't choose image");
		} else {
			String originalFileName = smallPortrait.getOriginalFilename();
			imageName = FilenameUtils.removeExtension(originalFileName);
			imageName += "_";
			imageName += UUID.randomUUID().toString();
			imageName += "." + FilenameUtils.getExtension(originalFileName);

			if (uploadService.uploadSmallPortrait(smallPortrait, imageName) != 200) {
				model.addAttribute("error", "Failed image load");

			} else {

				userService.updateAvatar(imageName, user.getId());
				user.setAvatar(imageName);
			}

		}
		model.addAttribute("user", user);
		return "userprofile";
	}

	@GetMapping(value = "/changePassword")
	public String showChangePassword(Model model, @RequestParam Optional<String> error) {

		return "changePassword";
	}

	@PostMapping(value = "/changePassword")
	@Transactional
	public String registerUserAccount(Model model, @RequestParam Optional<String> error, String password,
			String oldpassword) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		User user;
		CurrentUser currentUser = (CurrentUser) (principal);
		user = currentUser.getUser();
		if (!passwordEncoder.matches(oldpassword, user.getPassword())) {
			model.addAttribute("error", "Wrong old password!");
			return "changePassword";
		}

		String updatedPassword = passwordEncoder.encode(password);
		userService.updatePassword(updatedPassword, user.getId());
		model.addAttribute("user", user);
		return "userprofile";
	}

	@RequestMapping(value = "/addFilmStatus", method = RequestMethod.POST)
	@Transactional
	public String addFilmStatus(Model model, Integer filmId, Integer userId, Integer status) {
		User user = usersRepository.findById(userId).get();
		Film film = filmsRepository.findById(filmId).get();
		model.addAttribute("film",film);
		filmsRepository.findById(filmId).ifPresent(o -> model.addAttribute("similar", similarFilmsService.similarFilms(o)));

		
		if (status != 0) {
			Users_Films  users_Films=users_FilmsRepository.findByFilmAndUserId(user.getId(), film.getId());
			if(users_Films!=null) {
				users_FilmsRepository.updateStatus(status, users_Films.getId());
			}else {
				users_Films=new Users_Films(status, user, film);
				users_FilmsRepository.save(users_Films);
			}
		}
	model.addAttribute("filmStatus", status);
			return "Movie";
	}
}
