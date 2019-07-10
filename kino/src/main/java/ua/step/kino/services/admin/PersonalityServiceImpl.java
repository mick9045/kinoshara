package ua.step.kino.services.admin;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

import org.hibernate.dialect.function.PositionSubstringFunction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.step.kino.dto.PersonalityDTO;
import ua.step.kino.entities.Country;
import ua.step.kino.entities.Personality;
import ua.step.kino.entities.Position;
import ua.step.kino.repositories.CountryRepository;
import ua.step.kino.repositories.PersonalityRepository;
import ua.step.kino.services.UploadService;

@Service
public class PersonalityServiceImpl implements PersonalityService {

	@Autowired
	UploadService uploadService;
	
	@Autowired
	PersonalityRepository personalityRepository;
	
	@Autowired
	CountryRepository countryRepository;
	
	@Override
	public void add(PersonalityDTO personality) {
		System.out.println("Enter");
		String imageName = "";
		if (!personality.getPhoto().isEmpty()) {
			uploadService.uploadBigPortrait(personality.getPhoto());

			imageName = personality.getPhoto().getOriginalFilename();
		}
		Personality person = new Personality();
		person.setFirstName(personality.getFirstname());
		person.setLastName(personality.getLastname());
		person.setBiography(personality.getBiography());
		if (person.getBiography() != null) {
			person.setDateOfBirthday(new Date(personality.getBirthday().getTime()));
		}
		person.setPhoto(imageName + "_" + UUID.randomUUID().toString());
		if (!personality.getCountry().isEmpty()) {
			Country country = countryRepository.getOne(Integer.valueOf(personality.getCountry()));
			person.setCountry(country);
		}
		person.setPositions(personality.getPositions());
		person.setPositions(loadPositions());
		
		
		personalityRepository.save(person);

	}
	
	private List<Position> loadPositions() {
		return null;
	}
	
}
