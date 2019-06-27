package ua.step.kino.services;

import java.util.List;

import ua.step.kino.entities.Film;

public interface FilmSearchService {
	List<Film> searchFilmsByName(String name);
}
