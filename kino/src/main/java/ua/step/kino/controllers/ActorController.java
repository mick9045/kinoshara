package ua.step.kino.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.step.kino.entities.Actor;
import ua.step.kino.entities.Country;
import ua.step.kino.entities.Film;
import ua.step.kino.entities.Personality;
import ua.step.kino.entities.Position;
import ua.step.kino.repositories.ActorRepository;
import ua.step.kino.repositories.FilmRepository;
import ua.step.kino.repositories.PersonalityRepository;

/**
 * 
 * @author Kojevin
 *
 */

@Controller
@RequestMapping("/actors")
public class ActorController 
{
//	@Autowired ActorRepository actorRepository;
	
	@Autowired
	PersonalityRepository personalityRepository;
	
	@Autowired 
	FilmRepository filmRepository;
	
	@GetMapping
	public String showAll(Model model) 
	{
		//List<Actor> actors = actorRepository.findAll();
		List<Personality> actors = personalityRepository.findByPositions(Position.Actor);
		model.addAttribute("actors", actors);
		return "actors";
	}
	
	/**
	 * @author  AZavoruyev
	 */
	@GetMapping("/{id}")
	public String showActor(@PathVariable int id, Model model) {
		//actorRepository.findById(id).ifPresent(o -> model.addAttribute("actor", o));
		personalityRepository.findById(id).ifPresent(o -> model.addAttribute("actor", o));
		return "Actor";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteEntity(@PathVariable("id") int id, Model model) {
		Personality personality = personalityRepository.getOne(id);
		List<Film> films = filmRepository.findAll();
		films.forEach(film -> film.getActors().remove(personality));
				
		personalityRepository.delete(personality);
		return "redirect:/actors";
	}
}

