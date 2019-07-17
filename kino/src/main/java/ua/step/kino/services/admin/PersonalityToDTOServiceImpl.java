package ua.step.kino.services.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.step.kino.dto.PersonalityDTO;
import ua.step.kino.entities.Personality;
import ua.step.kino.repositories.PersonalityRepository;


@Service
public class PersonalityToDTOServiceImpl implements PersonalityToDTOService{

	@Autowired PersonalityRepository personRepo;
	
	
	@Override
	public PersonalityDTO transform(Personality person) {
		PersonalityDTO personDTO = new PersonalityDTO();
		personDTO.setBiography(person.getBiography());
		personDTO.setBirthday(person.getDateOfBirthday());
		personDTO.setCountry(person.getCountry().getName());
		personDTO.setFirstname(person.getFirstName());
		personDTO.setLastname(person.getLastName());
		//personDTO.setPhoto(person.getPhoto());
		personDTO.setPositions(person.getPositions());
		
		return personDTO;
	}

}
