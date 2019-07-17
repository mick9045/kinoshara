package ua.step.kino.services.admin;

import ua.step.kino.dto.FilmDTO;
import ua.step.kino.entities.Film;

public interface AddFilmService {
	Boolean add(FilmDTO filmDTO);
}
