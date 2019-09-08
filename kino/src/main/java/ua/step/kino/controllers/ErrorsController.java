package ua.step.kino.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.step.kino.entities.Film;

/**
 * 
 * @author AZavoruyev
 *
 */
@Controller
@RequestMapping("/errors")
public class ErrorsController {

	@GetMapping("/404")
	public String error404(Model model) {
		
		return "error404";
	}
	
	@GetMapping("/401")
	public String error401(Model model) {
		
		return "error401";
	}
}
