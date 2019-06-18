package ua.step.kino.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.step.kino.entities.Country;
import ua.step.kino.repositories.CountryRepository;

/**
 * 
 * @author mick
 *
 */

@Controller
@RequestMapping("/countries")
public class CountryController {
	@Autowired CountryRepository countryRepository;
	
	@GetMapping
	public String showAll(Model model) {
		List<Country> countries = countryRepository.findAll();
		model.addAttribute("countries", countries);
		return "countries";
	}
}
