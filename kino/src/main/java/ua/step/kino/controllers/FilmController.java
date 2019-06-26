package ua.step.kino.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.step.kino.entities.Film;
import ua.step.kino.repositories.FilmRepository;

/**
 * 
 * @author Aleksey
 *
 */


@Controller
@RequestMapping("/films")
public class FilmController {
	@Autowired FilmRepository filmsRepository;
	
	@GetMapping
	public String showAll(Model model) {
		List<Film> films = filmsRepository.findAll();
		model.addAttribute("films", films);
		return "films";
	}

}
