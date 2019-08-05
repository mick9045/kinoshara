package ua.step.kino.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.step.kino.entities.Film;
import ua.step.kino.entities.Genre;

/**
 * 
 * @author Julia
 *
 */
public interface GenreRepository extends JpaRepository<Genre, Integer>{

	@Query("select g from Genre g where lower(g.name) = :name")
	Genre findByName(@Param("name") String name);
}
