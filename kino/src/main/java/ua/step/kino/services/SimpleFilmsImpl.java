package ua.step.kino.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ua.step.kino.entities.Film;
import ua.step.kino.repositories.FilmRepository;

public class SimpleFilmsImpl implements SimpleFilmsServise {

	@Autowired
	FilmRepository filmRepo;

	@Override
	public List<Film> similarFilmsByQuery(String query, Film filmToCompare) {
		List<Film> allFilms = filmRepo.findAll();
		List<Film> resultFilms = new ArrayList<Film>();
		switch (query) {
		case "title":
			String[] strings = filmToCompare.getTitle().split(" ");
			for(Film film : allFilms)
			{
				film.getTitle();
				
			}
			break;
		case "name":
			break;
		case "genre":
			break;
		case "actor":
			break;
		case "director":
			break;
		}
		return null;
	}

	@Override
	public List<Film> similarFilmsBy() {

		return null;
	}

}
