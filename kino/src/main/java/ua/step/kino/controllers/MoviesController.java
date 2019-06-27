package ua.step.kino.controllers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ua.step.kino.entities.Film;
import ua.step.kino.repositories.FilmRepository;
import ua.step.kino.services.FilmFilterService;
import ua.step.kino.services.FilmSearchService;
import ua.step.kino.services.FilmSortService;

/**
 * 
 * @author Kojevin
 *
 */

@Controller
@RequestMapping("/")
public class MoviesController {

	@Autowired 
	FilmRepository filmsRepository;

	@Autowired(required = false)
	FilmSearchService searchService;
	
	@Autowired(required = false)
	FilmSortService sortService;

	@Autowired(required = false)
	FilmFilterService filterService;


	
	@GetMapping
	public String showAll(Model model) {
		List<Film> films = filmsRepository.findAll();
		model.addAttribute("films", films);
		return "allMovies";
	}
	
	@GetMapping(value = "search/{query}", produces = "application/json")
	@ResponseBody
	public String searchFilms(@PathVariable String query) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.writeValueAsString(searchService.searchFilmsByName(query));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return "";
		}
	}
	
	@GetMapping(value = "sort/{query}")
	public String sortFilms(@PathVariable String query, Model model) {
		List<Film> films = sortService.sortFilms(query);
		model.addAttribute("films", films);
		return "allMovies";
	}
	
	@GetMapping(value = "filter/{type}/{query}")
	public String filterFilms(@PathVariable String type, @PathVariable String query, Model model) {
		List<Film> films = filterService.filterBy(type, query);
		model.addAttribute("films", films);
		return "allMovies";
	}
	
	

}
