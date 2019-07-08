package ua.step.kino.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.step.kino.repositories.FilmRepository;
import ua.step.kino.repositories.ReviewRepository;

/**
 * 
 * @author AZavoruyev
 *
 */
@Service
public class ReviewServiceImpl implements ReviewService {
	private ReviewRepository reviewRepository;
	
	@Autowired
	public ReviewServiceImpl(ReviewRepository reviewRepository) {
	this.reviewRepository=reviewRepository;
	}
	
	@Override
	public Boolean isFilmReviewedByUser(Integer filmId, Integer userId) {
		return reviewRepository.isFilmReviewedByUser(userId, filmId).isEmpty();
	}

}
