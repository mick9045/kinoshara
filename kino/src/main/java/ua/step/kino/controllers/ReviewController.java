package ua.step.kino.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.step.kino.entities.Review;
import ua.step.kino.repositories.ReviewRepository;

/**
 * 
 * @author Azavoruyev
 *
 */
@Controller
@RequestMapping("/reviews")
public class ReviewController {
	@Autowired ReviewRepository reviewRepository;
	
	@GetMapping
	public String showAll(Model model) {
		List<Review> reviews = reviewRepository.findAll();
		model.addAttribute("reviews", reviews);
		return "reviews";
	}
}
