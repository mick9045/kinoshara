package ua.step.kino.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ua.step.kino.entities.Film;
import ua.step.kino.repositories.FilmRepository;

@Component("FilmFilterService")
public class FilmFilterServiceImpl implements FilmFilterService{

	@Autowired
	FilmRepository filmRepository;
	
	@Override
	public List<Film> filterFilmsByGenre(String genre) {
		return filmRepository.findByGenres(genre);
	}

	@Override
	public List<Film> filterBy(String filterType, String query) {
		switch(filterType) {
		case "genre":
			return filterFilmsByGenre(query);
		}
		return null;
	}
}