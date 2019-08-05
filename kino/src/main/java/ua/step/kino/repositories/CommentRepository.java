package ua.step.kino.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.step.kino.entities.Comment;
import ua.step.kino.entities.Film;
import ua.step.kino.entities.Review;

/**
 * 
 * @author Julia
 *
 */
public interface CommentRepository extends JpaRepository<Comment, Integer>{
	List<Comment> findByFilm(Film film);
}
