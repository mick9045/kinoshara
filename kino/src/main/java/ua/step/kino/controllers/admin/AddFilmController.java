package ua.step.kino.controllers.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.step.kino.repositories.CountryRepository;
import ua.step.kino.repositories.GenreRepository;


@Controller
@RequestMapping("admin/add/film")
public class AddFilmController {
	@Autowired
	CountryRepository countryRepo;
	
	@Autowired
	GenreRepository genreRepo;
	
	
	@GetMapping
	//@Secured("ROLE_ADMIN")
	String get(Model model)
	{
		model.addAttribute("countries", countryRepo.findAll());
		model.addAttribute("genres", genreRepo.findAll());
		return "admin/pages/add_film";
	}
}

