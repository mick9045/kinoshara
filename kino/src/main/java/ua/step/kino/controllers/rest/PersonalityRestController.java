package ua.step.kino.controllers.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ua.step.kino.entities.Personality;
import ua.step.kino.entities.Position;
import ua.step.kino.repositories.PersonalityRepository;

@RestController
@RequestMapping("/api/personality")
public class PersonalityRestController {
	@Autowired 
	PersonalityRepository personalRepository;

	@GetMapping("/{position}")
	public List<Personality> getPersonality(@PathVariable String position) {
		return personalRepository.findByPositions(Position.Actor);
	}
}
