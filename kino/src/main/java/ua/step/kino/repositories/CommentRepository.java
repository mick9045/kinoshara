package ua.step.kino.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.step.kino.entities.Comment;

/**
 * 
 * @author Aleksey
 *
 */
public interface CommentRepository extends JpaRepository<Comment, Integer>{
}