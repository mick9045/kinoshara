package ua.step.kino.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import ua.step.kino.entities.Role;
import ua.step.kino.repositories.RolesRepository;


	@Controller
	@RequestMapping("/roles")
	public class RoleController {
		@Autowired RolesRepository rolesRepository;
		
		@GetMapping
		public String showAll(Model model) {
			List<Role> roles = rolesRepository.findAll();
			model.addAttribute("roles", roles);
			return "roles";
		}
	}

