package ua.step.kino.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
		return "allMovies";
	}
	
	@GetMapping("{id}")
	public String showOne(@PathVariable int id, Model model)
	{
		filmsRepository.findById(id).ifPresent(o -> model.addAttribute("film", o));
		return "Movie";
	}

}
