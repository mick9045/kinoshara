package ua.step.kino.controllers;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ua.step.kino.entities.Film;
import ua.step.kino.entities.Review;
import ua.step.kino.entities.User;
import ua.step.kino.repositories.FilmRepository;
import ua.step.kino.repositories.ReviewRepository;
import ua.step.kino.security.CurrentUser;
import ua.step.kino.services.ReviewServiceImpl;
import ua.step.kino.services.SimilarFilmsImpl;

/**
 * 
 * @author Aleksey
 *
 */

@Controller
@RequestMapping("/films")
public class FilmController {
	@Autowired
	FilmRepository filmsRepository;
	@Autowired
	ReviewServiceImpl reviewService;
	
	@Autowired 
	SimilarFilmsImpl similarFilmsService;

	@GetMapping
	public String showAll(Model model) {
		List<Film> films = filmsRepository.findAll();
		model.addAttribute("films", films);
		return "allMovies";
	}

	@GetMapping("/{id}")
	public String showOne(@PathVariable int id, Model model) {
		filmsRepository.findById(id).ifPresent(o -> model.addAttribute("film", o));
			
		
		//similarFilmsService.similarFilms(filmsRepository.findById(id));
		filmsRepository.findById(id).ifPresent(o -> model.addAttribute("similar", similarFilmsService.similarFilms(o)));
	
		//films.forEach(f -> System.out.println(f.getTitle()));
		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		Boolean reviewed = false;
		if (principal instanceof CurrentUser) {
			CurrentUser currentUser = (CurrentUser) (principal);
			reviewed = reviewService.isFilmReviewedByUser(id, currentUser.getId() );
		}
		model.addAttribute("reviewed", reviewed);
		
		
		return "Movie";
	}

}
