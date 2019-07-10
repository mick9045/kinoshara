package ua.step.kino.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;

import ua.step.kino.entities.Director;
import ua.step.kino.entities.Film;
import ua.step.kino.entities.Genre;
import ua.step.kino.repositories.FilmRepository;

public class SimilarFilmsImpl implements SimilarFilmsServise {

	@Autowired
	FilmRepository filmRepo;

	@Override
	public Set<Film> similarFilmsByTitle(Film filmToCompare) {
		List<Film> allFilms = filmRepo.findAll();
		List<Film> resultFilms = new ArrayList<Film>();

		String[] strings = filmToCompare.getTitle().split(" ");
		for (Film film : allFilms) {
			film.getTitle();

		}
		return null;
	}

	@Override
	public Set<Film> similarFilmsByDirectors(Film filmToCompare) 
	{
		List<Film> allFilms = filmRepo.findAll();
		Set<Film> resultFilms = new HashSet<Film>();

		for(Film film: allFilms)
		{
			for(Director director : film.getDirectors())
			{
				for(Director director2 : filmToCompare.getDirectors())
				{
					if(director.getId() == director2.getId())
					{
						resultFilms.add(film);
					}
				}
			}
		}
		
		return resultFilms;
	}

	@Override
	public Set<Film> similarFilmsByGenres(Film filmToCompare) {
		List<Film> allFilms = filmRepo.findAll();
		Set<Film> resultFilms = new HashSet<Film>();

		for(Film film: allFilms)
		{
			for(Genre genre : film.getGenres())
			{
				for(Genre genre2 : filmToCompare.getGenres())
				{
					if(genre.getId() == genre2.getId())
					{
						resultFilms.add(film);
					}
				}
			}
		}
		
		return resultFilms;
	}

	@Override
	public Set<Film> similarFilmsByActors(Film filmToCompare) {
		List<Film> allFilms = filmRepo.findAll();
		Set<Film> resultFilms = new HashSet<Film>();

		for(Film film: allFilms)
		{
			for(Genre genre : film.getGenres())
			{
				for(Genre genre2 : filmToCompare.getGenres())
				{
					if(genre.getId() == genre2.getId())
					{
						resultFilms.add(film);
					}
				}
			}
		}
		
		return resultFilms;
	}

	@Override
	public Set<Film> similarFilms(Film filmToCompare) {
		Set<Film> resultFilms = new HashSet<Film>();
		
		resultFilms.addAll(similarFilmsByActors(filmToCompare));
		resultFilms.addAll(similarFilmsByGenres(filmToCompare));
		resultFilms.addAll(similarFilmsByDirectors(filmToCompare));
		
		return resultFilms;
		
	}

}
