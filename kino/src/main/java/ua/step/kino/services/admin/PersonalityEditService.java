package ua.step.kino.services.admin;

import java.util.UUID;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.step.kino.dto.PersonalityDTO;
import ua.step.kino.entities.Country;
import ua.step.kino.entities.Personality;
import ua.step.kino.repositories.CountryRepository;
import ua.step.kino.repositories.PersonalityRepository;
import ua.step.kino.services.UploadService;

@Service
public class PersonalityEditService {

	@Autowired
	UploadService uploadService;

	@Autowired
	PersonalityRepository personalityRepository;

	@Autowired
	CountryRepository countryRepository;

	public boolean add(PersonalityDTO personalityDTO, int id) {
		System.out.println("Enter");
		
		Personality person = personalityRepository.getOne(id);
		
		String imageName = person.getPhoto();
		
		
		if (personalityDTO.getPhoto() != null) {
			if (!personalityDTO.getPhoto().isEmpty()) {
				String originalName = personalityDTO.getPhoto().getOriginalFilename();
				imageName = FilenameUtils.removeExtension(originalName);
				imageName += "_";
				imageName += UUID.randomUUID().toString();
				imageName += "." + FilenameUtils.getExtension(originalName);
				System.out.println("image name: " + imageName);
				if (uploadService.uploadBigPortrait(personalityDTO.getPhoto(), imageName) != 200) {
					System.out.println("failed image load");
					return false;
				}
			}
			person.setPhoto(imageName);
		}
		person.setFirstName(personalityDTO.getFirstName());
		person.setLastName(personalityDTO.getLastName());
		person.setBiography(personalityDTO.getBiography());
		if (personalityDTO.getBirthday() != null) {
			person.setDateOfBirthday(personalityDTO.getBirthday());
		}

		if (!personalityDTO.getCountry().isEmpty() && !personalityDTO.getCountry().equals("-1")) {
			Country country = countryRepository.getOne(Integer.valueOf(personalityDTO.getCountry()));
			person.setCountry(country);
		}
		person.setPositions(personalityDTO.getPositions());

		personalityRepository.save(person);
		return true;
	}

}
