package ua.step.kino.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ua.step.kino.entities.Country;
import ua.step.kino.entities.Film;
import ua.step.kino.entities.Genre;
import ua.step.kino.repositories.FilmRepository;
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

	@Autowired 
	FilmRepository filmRepository;
	
	@GetMapping
	public String showAll(Model model) {
		List<Genre> genres = genreRepository.findAll();
		model.addAttribute("genres", genres);
		return "genres";
	}

	@GetMapping(value = "/all", produces = "application/json")
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

	@GetMapping("/add")
	public String showAddForm(Genre genre) {
		return "genre-add";
	}

	@PostMapping("/add")
	public String addEntity(@Valid Genre genre, @RequestParam Optional<String> error, BindingResult result,
			Model model) {

		if (genreRepository.findByName(genre.getName().toLowerCase()) != null) {
			model.addAttribute("error", "This genre is already exist!");
			return "genre-add";
		}
		if (result.hasErrors()) {
			return "genre-add";
		}

		genreRepository.save(genre);
		return "redirect:/genre";
	}

	@GetMapping("/edit/{id}")
	public String showUpdateForm(@PathVariable("id") int id, Model model) {
		Genre genre = genreRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));

		model.addAttribute("genre", genre);
		return "genre-edit";
	}

	@PostMapping("/edit/{id}")
	public String updateEntity(@PathVariable("id") int id,@RequestParam Optional<String> error, @Valid Genre genre, BindingResult result, Model model) {
		if (genreRepository.findByName(genre.getName().toLowerCase()) != null) {
			model.addAttribute("error", "This genre is already exist!");
			return "genre-edit";
		}
		if (result.hasErrors()) {
			genre.setId(id);
			return "genre-edit";
		}

		genreRepository.save(genre);
		return "redirect:/genre";
	}

	
}
