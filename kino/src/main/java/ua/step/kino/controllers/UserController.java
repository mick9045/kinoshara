package ua.step.kino.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.step.kino.entities.User;
import ua.step.kino.repositories.UsersRepository;



	@Controller
	@RequestMapping("/users")
	public class UserController {
		@Autowired UsersRepository usersRepository;
		
		@GetMapping
		public String showAll(Model model) {
			List<User> users = usersRepository.findAll();
			model.addAttribute("users", users);
			return "users";
		}
	}

