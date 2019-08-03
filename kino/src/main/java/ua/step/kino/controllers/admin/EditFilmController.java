package ua.step.kino.controllers.admin;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ua.step.kino.dto.FilmDTO;
import ua.step.kino.repositories.CountryRepository;
import ua.step.kino.repositories.FilmRepository;
import ua.step.kino.repositories.GenreRepository;
import ua.step.kino.services.admin.AddFilmService;
import ua.step.kino.services.admin.EditFilmService;

@Controller
@RequestMapping("admin/edit/film")
public class EditFilmController {
	@Autowired
	CountryRepository countryRepo;
	
	@Autowired
	GenreRepository genreRepo;
	
	@Autowired
	FilmRepository filmRepo;
	
	@Autowired
	EditFilmService editFilmService;
	
	@GetMapping("/{id}")
	String get(@PathVariable int id, Model model) {
		
		filmRepo.findById(id).ifPresent(f -> model.addAttribute("film", f));
		model.addAttribute("countries", countryRepo.findAll());
		model.addAttribute("genres", genreRepo.findAll());
		
		return "admin/pages/edit_film";
	}
	
	@PostMapping("/{id}")
	@Secured("ROLE_ADMIN")
	String post(@PathVariable int id, @Valid FilmDTO filmDTO, Model model, Errors errors, RedirectAttributes redir) {
		if (!errors.hasErrors() && editFilmService.add(filmDTO, id)) {
			redir.addFlashAttribute("result", "success");
		} else {
			redir.addFlashAttribute("result", "fail");
		}
		return "redirect:/admin/add/film";
	}
}
