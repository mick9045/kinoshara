package ua.step.kino.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.step.kino.entities.Actor;
import ua.step.kino.repositories.ActorRepository;

/**
 * 
 * @author Kojevin
 *
 */

@Controller
@RequestMapping("/actors")
public class ActorController 
{
	@Autowired ActorRepository actorRepository;
	
	@GetMapping
	public String showAll(Model model) 
	{
		List<Actor> actors = actorRepository.findAll();
		model.addAttribute("actors", actors);
		return "actors";
	}
	
	
}

