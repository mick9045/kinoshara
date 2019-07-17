package ua.step.kino.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.step.kino.entities.Genre;
import ua.step.kino.services.CountryService;

@RequestMapping("/test/modal")
@Controller
public class ModalWindowTestController {
	@Autowired 
	CountryService countryService;
	
	@GetMapping
	public String showAll(Model model) {
		model.addAttribute("countries", countryService.getAll());
		return "modaltest";
	}

}
