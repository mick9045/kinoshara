package ua.step.kino.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ua.step.kino.entities.Film;
import ua.step.kino.repositories.FilmRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

@Component("FilmSortService")
public class FilmSorter implements FilmSortService {

	@Autowired 
	FilmRepository filmsRepository;
	
	@Override
	public List<Film> sortFilmsByRleaseYear() {
		
		return filmsRepository.findAll(Sort.by(Sort.Direction.ASC, "releaseYear"));
	}

	@Override
	public List<Film> sortFilmsByRate() {
		return filmsRepository.findAll(Sort.by(Sort.Direction.ASC, "rate"));
	}

	@Override
	public List<Film> sortFilmsByViewsFrequency() {
		return filmsRepository.findAll(Sort.by(Sort.Direction.ASC, "views"));
	}

	@Override
	public List<Film> sortFilmsByAdditionDate() {
		return filmsRepository.findAll(Sort.by(Sort.Direction.ASC, "additionDate"));
	}

	@Override
	public List<Film> sortFilmsByReviewsCount() {
	
		List<Film> list = filmsRepository.findAll();
		
		list.sort((f1, f2) ->{
			 if(f1.getReviews().size() == f2.getReviews().size()){
			        return 0;
			    }
			 return f1.getReviews().size() > f2.getReviews().size() ? 1 : -1;
		});
		
		return list;
	}

	@Override
	public List<Film> sortFilms(String query) {
		switch(query) {
		case "year":
			return sortFilmsByRleaseYear();
		case "rate":
			return sortFilmsByRate();
		case "views":
			return sortFilmsByViewsFrequency();
		case "added":
			return sortFilmsByAdditionDate();
		case "reviews":
			return sortFilmsByReviewsCount();
			
		}
		
		return null;
	}

}
