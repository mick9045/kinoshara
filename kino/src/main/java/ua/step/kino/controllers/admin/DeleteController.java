package ua.step.kino.controllers.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.step.kino.entities.Comment;
import ua.step.kino.entities.Country;
import ua.step.kino.entities.Film;
import ua.step.kino.entities.Genre;
import ua.step.kino.entities.Personality;
import ua.step.kino.entities.Review;
import ua.step.kino.entities.Users_Films;
import ua.step.kino.repositories.CommentRepository;
import ua.step.kino.repositories.CountryRepository;
import ua.step.kino.repositories.FilmRepository;
import ua.step.kino.repositories.GenreRepository;
import ua.step.kino.repositories.PersonalityRepository;
import ua.step.kino.repositories.ReviewRepository;
import ua.step.kino.repositories.Users_FilmsRepository;

/**
 * 
 * @author AZavoruyev
 *
 */

@Controller
@RequestMapping("/")
public class DeleteController {

	@Autowired
	CountryRepository countryRepository;

	@Autowired
	FilmRepository filmRepository;

	@Autowired
	PersonalityRepository personalityRepository;
	
	@Autowired 
	CommentRepository commentRepository;
	
	@Autowired 
	ReviewRepository reviewRepository;
	
	@Autowired
	GenreRepository genreRepository;
	
	@Autowired
	Users_FilmsRepository users_FilmsRepository;

	@GetMapping("/countries/delete/{id}")
	public String deleteCountry(@PathVariable("id") int id, Model model) {
		Country country = countryRepository.getOne(id);

		List<Film> films = filmRepository.findAll();
		films.forEach(film -> film.getCountries().remove(country));

		List<Personality> personalities = personalityRepository.findByCountry(country);
		personalities.forEach(personality -> personality.setCountry(null));

		countryRepository.delete(country);
		return "redirect:/countries";
	}
	
	@GetMapping("/actors/delete/{id}")
	public String deleteActor(@PathVariable("id") int id, Model model) {
		Personality personality = personalityRepository.getOne(id);
		List<Film> films = filmRepository.findAll();
		films.forEach(film -> film.getActors().remove(personality));
		personalityRepository.delete(personality);
		return "redirect:/actors";
	}
	
	@GetMapping("/directors/delete/{id}")
	public String deleteDirector(@PathVariable("id") int id, Model model) {
		Personality personality = personalityRepository.getOne(id);
		
		List<Film> films = filmRepository.findAll();
		films.forEach(film -> film.getDirectors().remove(personality));
				
		personalityRepository.delete(personality);
		return "redirect:/directors";
	}
	
	@GetMapping("/films/delete/{id}")
	@Transactional
	public String deleteFilm(@PathVariable("id") int id, Model model) {
		Film film = filmRepository.getOne(id);

		List<Personality> personalities=personalityRepository.findAll();
		personalities.forEach(personality->personality.getFilmsActed().remove(film));
		personalities.forEach(personality->personality.getFilmsDirected().remove(film));
		
		users_FilmsRepository.deleteByFilm(id);
		
		List<Review> reviews=reviewRepository.findByFilm(film);
		reviews.forEach(review->review.setFilm(null));
		
		List<Comment> comments=commentRepository.findByFilm(film);
		comments.forEach(comment->comment.setFilm(null));
		
		film.getCountries().clear();
		film.getGenres().clear();
		filmRepository.delete(film);
		return "redirect:/films/list";
	}
	
	@GetMapping("/genre/delete/{id}")
	public String deleteEntity(@PathVariable("id") int id, Model model) {
		Genre genre = genreRepository.getOne(id);
		
		List<Film> films = filmRepository.findAll();
		
		films.forEach(film -> film.getGenres().remove(genre));
		
		genreRepository.delete(genre);
		return "redirect:/genre";
	}
	
}
