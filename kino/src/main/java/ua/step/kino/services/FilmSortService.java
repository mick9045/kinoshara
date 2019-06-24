package ua.step.kino.services;

import java.util.List;

import ua.step.kino.entities.Film;

public interface FilmSortService {
	List<Film> sortFilmsByRleaseYear();
	List<Film> sortFilmsByRate();
	List<Film> sortFilmsByViewsFrequency();
	List<Film> sortFilmsByAdditionDate();
	List<Film> sortFilmsByReviewsCount();
	List<Film> sortFilms(String query);
}
