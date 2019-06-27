package ua.step.kino.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ua.step.kino.entities.Genre;
import ua.step.kino.repositories.GenreRepository;

/**
 * 
 * @author Julia
 *
 */
@Controller
@RequestMapping("/genre")
public class GenreController {
	@Autowired 
	GenreRepository genreRepository;
	
	@GetMapping
	public String showAll(Model model) {
		List<Genre> genres = genreRepository.findAll();
		model.addAttribute("genres", genres);
		return "genres";
	}
	
	@GetMapping("/all")
	@ResponseBody
	public String getAll() {
	    ObjectMapper mapper = new ObjectMapper();
	    try {
	      return mapper.writeValueAsString(genreRepository.findAll());
	    } catch (JsonProcessingException e) {
	      e.printStackTrace();
	      return "";
	    }
	}
}
