package ua.step.kino.controllers.rest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ua.step.kino.dto.FilmDTO;
import ua.step.kino.repositories.FilmRepository;
import ua.step.kino.services.admin.AddFilmService;

@RestController
@RequestMapping("api/films")
public class FilmRestController {
	@Autowired
	FilmRepository filmRepo;
	
	@Autowired
	AddFilmService addFilmService;
	
	
	@PostMapping("/add")
	@Secured("ROLE_ADMIN")
	String post(@Valid FilmDTO filmDTO, Model model, Errors errors, RedirectAttributes redir) {
		if (!errors.hasErrors() && addFilmService.add(filmDTO)) {
			model.addAttribute("result", "success");
		} else {
			model.addAttribute("result", "fail");
		}
		return "admin/pages/add_film";
	}
}
