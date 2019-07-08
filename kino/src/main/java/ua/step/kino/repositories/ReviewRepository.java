package ua.step.kino.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.step.kino.entities.Review;
/**
 * 
 * @author AZavoruyev
 *
 */
public interface ReviewRepository extends JpaRepository<Review, Integer> {

}
