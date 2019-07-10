package ua.step.kino.services;

import java.util.List;

import ua.step.kino.entities.Film;

public interface SimilarFilmsServise {
	List<Film> similarFilmsByQuery(String query, Film filmToCompare);
	List<Film> similarFilmsBy();
}
