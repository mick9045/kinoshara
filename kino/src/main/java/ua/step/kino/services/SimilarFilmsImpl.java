package ua.step.kino.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ua.step.kino.entities.Director;
import ua.step.kino.entities.Film;
import ua.step.kino.entities.Genre;
import ua.step.kino.repositories.FilmRepository;


@Component("SimilarFilmsImpl")
public class SimilarFilmsImpl implements SimilarFilmsServise {

	@Autowired
	FilmRepository filmRepo;
	

	private int calculate(String x, String y) {
        if (x.isEmpty()) {
            return y.length();
        }
 
        if (y.isEmpty()) {
            return x.length();
        } 
 
        int substitution = calculate(x.substring(1), y.substring(1)) 
         + costOfSubstitution(x.charAt(0), y.charAt(0));
        int insertion = calculate(x, y.substring(1)) + 1;
        int deletion = calculate(x.substring(1), y) + 1;
 
        return min(substitution, insertion, deletion);
    }
 
    private int costOfSubstitution(char a, char b) {
        return a == b ? 0 : 1;
    }
 
    private int min(int... numbers) {
        return Arrays.stream(numbers)
          .min().orElse(Integer.MAX_VALUE);
    }

	@Override
	public Set<Film> similarFilmsByTitle(Film filmToCompare) 
	{
		List<Film> allFilms = filmRepo.findAll();
		Set<Film> resultFilms = new HashSet<Film>();
		
		for(Film f : allFilms)
		{
			if(f.getTitle().compareTo(filmToCompare.getTitle()) <= 2)
			{
				System.out.println("JOINEDJOINEDJOINEDJOINEDJOINEDJOINED");
				resultFilms.add(f);
			}
		}
		return resultFilms;
	}

	@Override
	public Set<Film> similarFilmsByDirectors(Film filmToCompare) 
	{
		List<Film> allFilms = filmRepo.findAll();
		Set<Film> resultFilms = new HashSet<Film>();


		
		
		for(Film film: allFilms)
		{	
			//resultFilms.addAll(Stream.of(film.getDirectors(), filmToCompare.getDirectors()).map((f1, f2) -> (f1.getId() == f2.getId())).collect(Collectors.toSet()));
			
			
			for(Director director : film.getDirectors())
			{
				for(Director director2 : filmToCompare.getDirectors())
				{
					if(director.getId() == director2.getId())
					{
						resultFilms.add(film);
						System.out.println("ADDED");
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
		resultFilms.addAll(similarFilmsByTitle(filmToCompare));
		resultFilms.remove(filmToCompare);
		
		resultFilms.forEach(f -> System.out.println(f.getTitle()));
		
		return resultFilms;
		
	}

}
