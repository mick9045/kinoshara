package ua.step.kino.controllers.rest;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ua.step.kino.dto.PersonalityDTO;
import ua.step.kino.entities.Personality;
import ua.step.kino.entities.Position;
import ua.step.kino.repositories.PersonalityRepository;
import ua.step.kino.services.admin.PersonalityToDTOServiceImpl;

@RestController
@RequestMapping("/api/personality")
public class PersonalityRestController {
	@Autowired 
	PersonalityRepository personalRepository;

	@Autowired
	PersonalityToDTOServiceImpl perToDTO;
	
	@GetMapping("/{position}")
	public int getPersonality(@PathVariable String position) {
		return personalRepository.findByPositions(Position.Actor).size();
	}
	
	@GetMapping("find/{position}/{name}")
	public Set<PersonalityDTO> getByName(@PathVariable String name, @PathVariable String position)
	{
		Set<PersonalityDTO> result = new HashSet<PersonalityDTO>();
		
		List<Personality> people = personalRepository.findByPositions(Position.valueOf(position));
		
		people.stream().forEach(person -> {
			if(person.getFirstName().contains(name) || person.getLastName().contains(name))
				result.add(perToDTO.transform(person));
		});
			
		result.stream().limit(10).collect(Collectors.toSet());
		
		return result;
	}
}
