package ua.step.kino.services;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ua.step.kino.entities.Actor;
import ua.step.kino.entities.Director;
import ua.step.kino.entities.Film;
import ua.step.kino.entities.Genre;
import ua.step.kino.repositories.FilmRepository;
/**
 * 
 * @author Aleksey
 *
 */

@Component("SimilarFilmsImpl")
public class SimilarFilmsImpl implements SimilarFilmsServise {

	@Autowired
	FilmRepository filmRepo;
	
	@Override
	public Set<Film> similarFilmsByTitle(Film filmToCompare) 
	{
		List<Film> allFilms = filmRepo.findAll();
		Set<Film> resultFilms = new HashSet<Film>();
		
		allFilms.forEach(film -> { if(Math.abs(film.getTitle().compareTo(filmToCompare.getTitle())) <= 2) resultFilms.add(film); });
		
		return resultFilms;
	}

	@Override
	public Set<Film> similarFilmsByDirectors(Film filmToCompare) 
	{
		List<Film> allFilms = filmRepo.findAll();
		Set<Film> resultFilms = new HashSet<Film>();


		allFilms.stream().flatMap(d -> d.getDirectors().stream()).forEach(director -> {
			for(Director director2 : filmToCompare.getDirectors())
			{
				if(director.getId() == director2.getId())
					resultFilms.addAll(director.getFilmsDirected());
			}
		});
		
		return resultFilms;
	}

	@Override
	public Set<Film> similarFilmsByGenres(Film filmToCompare) {
		List<Film> allFilms = filmRepo.findAll();
		Set<Film> resultFilms = new HashSet<Film>();

		allFilms.stream().flatMap(g -> g.getGenres().stream()).forEach(genre -> {
			for(Genre genre2 : filmToCompare.getGenres())
			{
				if(genre.getId() == genre2.getId())
					resultFilms.addAll(allFilms.stream().filter(film -> film.getGenres().contains(genre)).collect(Collectors.toSet()));
			}
		});
		
		
		return resultFilms;
	}

	@Override
	public Set<Film> similarFilmsByActors(Film filmToCompare) {
		List<Film> allFilms = filmRepo.findAll();
		Set<Film> resultFilms = new HashSet<Film>();

		allFilms.stream().flatMap(a -> a.getActors().stream()).forEach(actor -> {
			for(Actor actor2 : filmToCompare.getActors())
			{
				if(actor.getId() == actor2.getId())
					resultFilms.addAll(actor.getFilmsActed());
			}
		});
		
		return resultFilms;
	}

	@Override
	public Set<Film> similarFilms(Film filmToCompare) {
		Set<Film> resultFilms = new HashSet<Film>();
		
		resultFilms.addAll(similarFilmsByActors(filmToCompare));
		resultFilms.addAll(similarFilmsByGenres(filmToCompare));
		resultFilms.addAll(similarFilmsByDirectors(filmToCompare));
		resultFilms.addAll(similarFilmsByTitle(filmToCompare));
		resultFilms.remove(filmToCompare);
		
		//resultFilms.forEach(f -> System.out.println(f.getTitle()));
		
		return resultFilms;
		
	}

}
