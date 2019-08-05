package ua.step.kino.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.step.kino.entities.Country;
import ua.step.kino.entities.Film;
import ua.step.kino.entities.Personality;
import ua.step.kino.entities.Review;
/**
 * 
 * @author AZavoruyev
 *
 */
public interface ReviewRepository extends JpaRepository<Review, Integer> {
	@Query("from Review r inner join r.user u inner join r.film f where u.id = :userId AND f.id = :filmId" )
	List<Review> isFilmReviewedByUser(@Param("userId")Integer userId, @Param("filmId")Integer filmId );
	
	List<Review> findByFilm(Film film);
}
