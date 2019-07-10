package ua.step.kino.services;

import java.util.List;
import java.util.Set;

import ua.step.kino.entities.Film;

public interface SimilarFilmsServise {
	Set<Film> similarFilmsByTitle(Film filmToCompare);
	Set<Film> similarFilmsByDirectors(Film filmToCompare);
	Set<Film> similarFilmsByGenres(Film filmToCompare);
	Set<Film> similarFilmsByActors(Film filmToCompare);
	Set<Film> similarFilms(Film filmToCompare);
}
