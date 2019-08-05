package ua.step.kino.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.step.kino.entities.Director;
import ua.step.kino.entities.Film;
import ua.step.kino.entities.Personality;
import ua.step.kino.entities.Position;
import ua.step.kino.repositories.DirectorRepository;
import ua.step.kino.repositories.FilmRepository;
import ua.step.kino.repositories.PersonalityRepository;

/**
 * 
 * @author Azavoruyev
 *
 */
@Controller
@RequestMapping("/directors")
public class DirectorController {
//	@Autowired DirectorRepository directorRepository;

	@Autowired
	PersonalityRepository personalityRepository;

	@GetMapping
	public String showAll(Model model) {
		// List<Director> directors = directorRepository.findAll();
		List<Personality> directors = personalityRepository.findByPositions(Position.Director);
		model.addAttribute("directors", directors);
		return "directors";
	}

	@GetMapping("/{id}")
	public String showActor(@PathVariable int id, Model model) {
		// directorRepository.findById(id).ifPresent(o -> model.addAttribute("director",
		// o));
		personalityRepository.findById(id).ifPresent(o -> model.addAttribute("director", o));
		return "Director";
	}

}
