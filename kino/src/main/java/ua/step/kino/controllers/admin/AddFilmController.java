package ua.step.kino.controllers.admin;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ua.step.kino.dto.FilmDTO;
import ua.step.kino.repositories.CountryRepository;
import ua.step.kino.repositories.FilmRepository;
import ua.step.kino.repositories.GenreRepository;
import ua.step.kino.services.admin.AddFilmService;


@Controller
@RequestMapping("admin/add/film")
public class AddFilmController {
	@Autowired
	CountryRepository countryRepo;
	
	@Autowired
	GenreRepository genreRepo;
	
	@Autowired
	FilmRepository filmRepo;
	
	@Autowired
	AddFilmService addFilmService;
	
	
	@GetMapping
	//@Secured("ROLE_ADMIN")
	String get(Model model)
	{
		model.addAttribute("countries", countryRepo.findAll());
		model.addAttribute("genres", genreRepo.findAll());
		return "admin/pages/add_film";
	}
	

	
	
	@PostMapping()
	//@Secured("ROLE_ADMIN")
	String post(@Valid FilmDTO filmDTO, Model model, Errors errors, RedirectAttributes redir) {
		if (!errors.hasErrors() && addFilmService.add(filmDTO)) {
			model.addAttribute("result", "success");
		} else {
			model.addAttribute("result", "fail");
		}
		return "redirect:/admin/add/film";
	}
}

