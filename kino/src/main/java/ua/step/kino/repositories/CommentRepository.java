package ua.step.kino.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.step.kino.entities.Comment;

/**
 * 
 * @author Julia
 *
 */
public interface CommentRepository extends JpaRepository<Comment, Integer>{

}
