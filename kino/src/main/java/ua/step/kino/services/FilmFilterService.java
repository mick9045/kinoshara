package ua.step.kino.services;

import java.util.List;

import ua.step.kino.entities.Film;

public interface FilmFilterService {
	List<Film> flterFilmsByGenre(String genre);
	List<Film> filterBy(String filterType, String query);
}
