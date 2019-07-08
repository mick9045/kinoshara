package ua.step.kino.services;

import java.util.List;

import ua.step.kino.entities.Film;

public interface SimpleFilmsServise {
	List<Film> similarFilmsByQuery(String query, Film filmToCompare);
	List<Film> similarFilmsBy();
}
