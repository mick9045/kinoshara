package ua.step.kino.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.step.kino.entities.Film;

/**
 * 
 * @author Aleksey
 *
 */

public interface FilmRepository extends JpaRepository<Film, Integer> {

}
