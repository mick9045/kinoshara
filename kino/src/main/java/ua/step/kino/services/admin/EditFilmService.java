package ua.step.kino.services.admin;

import ua.step.kino.dto.FilmDTO;

public interface EditFilmService {

	Boolean add(FilmDTO filmDTO, int id);
}
