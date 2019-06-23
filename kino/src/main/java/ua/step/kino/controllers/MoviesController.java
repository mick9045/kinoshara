package ua.step.kino.controllers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.step.kino.entities.Film;
import ua.step.kino.repositories.FilmRepository;

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
	
	@GetMapping
	public String showAll(Model model) {
		List<Film> films = filmsRepository.findAll();
		model.addAttribute("films", films);
		return "allMovies";
	}
	
	@GetMapping("image/{name}")
	public void getImage(@PathVariable String name, HttpServletResponse httpServletResponse) {
		String path = "http://kinoshara.rf.gd/images/";
		httpServletResponse.setHeader("Location", path + name);
		httpServletResponse.setStatus(302);
	}

}
