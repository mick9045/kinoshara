package ua.step.kino.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.step.kino.entities.Film;
import ua.step.kino.repositories.FilmRepository;
/**
 * 
 * @author AZavoruyev
 *
 */
@Service 
public class FilmSearchServiceImpl implements FilmSearchService {
	private FilmRepository filmRepository;
	
	@Autowired
	public FilmSearchServiceImpl(FilmRepository filmRepository)
	{
		this.filmRepository=filmRepository;
	}
	
	@Override
	public List<Film> searchFilmsByName(String name) {
		 List<Film> films=filmRepository.findAll();
		 List<Film> afterSearch;
		 //метод поиска фильма по названию
		 
		return null;
	}

}
