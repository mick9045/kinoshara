package ua.step.kino.controllers;

import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.step.kino.entities.Film;
import ua.step.kino.entities.Review;
import ua.step.kino.entities.User;
import ua.step.kino.repositories.FilmRepository;
import ua.step.kino.repositories.ReviewRepository;
import ua.step.kino.repositories.UsersRepository;

/**
 * 
 * @author Azavoruyev
 *
 */
@Controller
@RequestMapping("/reviews")
public class ReviewController {
	@Autowired ReviewRepository reviewRepository;
	@Autowired FilmRepository filmsRepository;
	@Autowired UsersRepository usersRepository;
	
	@GetMapping
	public String showAll(Model model) {
		List<Review> reviews = reviewRepository.findAll();
		model.addAttribute("reviews", reviews);
		return "reviews";
	}
	
	@RequestMapping(value = "/addReview", method=RequestMethod.POST)
	public String addReview(Model model, Integer filmId, Integer userId, String text, Boolean isGood) {
		Review review = new Review();
		review.setFilm(filmsRepository.findById(filmId).get());
		review.setUser(usersRepository.findById(userId).get());
		review.setText(text);
		review.setIsGood(isGood);
		review.setDate(new Date());
		reviewRepository.save(review);
		
		Film film = filmsRepository.getOne(filmId);
		film.setReviews(review);
		filmsRepository.save(film);
		
		//System.out.println(text + isGood + userId+ filmId);
		 return "redirect:/films/" + review.getFilm().getId();
	}
	
}
