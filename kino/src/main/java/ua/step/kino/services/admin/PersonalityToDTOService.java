package ua.step.kino.services.admin;

import ua.step.kino.dto.PersonalityDTO;
import ua.step.kino.entities.Personality;

public interface PersonalityToDTOService {
	PersonalityDTO transform(Personality person);
}
