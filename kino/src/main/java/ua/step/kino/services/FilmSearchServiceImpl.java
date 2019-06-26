package ua.step.kino.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import ua.step.kino.entities.Film;
import ua.step.kino.repositories.FilmRepository;

/**
 * 
 * @author AZavoruyev
 *
 */
@Service
//@Component("FilmSearchService")
public class FilmSearchServiceImpl implements FilmSearchService {
	private FilmRepository filmRepository;

	@Autowired
	public FilmSearchServiceImpl(FilmRepository filmRepository) {
		this.filmRepository = filmRepository;
	}

	@Override
	public List<Film> searchFilmsByName(String name) {
//		System.out.println(name);
//		if (!name.isEmpty()) {
//			List<Film> films = filmRepository.findAll();
//			List<Film> afterSearch = new ArrayList<Film>();
//			String search = name.toLowerCase().replaceAll("[^\\w\\s]"," ").replaceAll("\\s+"," ");
//			// метод поиска фильма по названию
//			for (Film film : films) {
//				String title = film.getTitle().toLowerCase().replaceAll("[^\\w\\s]"," ").replaceAll("\\s+"," ");
//				if (title.contains(search)) {
//					afterSearch.add(film);
//				}
//			}
//			return afterSearch;
//		} else {
//			return null;
//		}
	
	
		return filmRepository.searchFilmsByName(name);
	}

}
