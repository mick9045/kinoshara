package ua.step.kino.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.step.kino.entities.Film;

/**
 * 
 * @author Aleksey
 *
 */

public interface FilmRepository extends JpaRepository<Film, Integer> {
	/**
	 * @author Azavoruyev
	 * @param search by contains
	 * @return
	 */
	@Query("select b from Film b where b.title like %:title%")
	   List<Film>  findByContainsName(@Param("title") String name);
}
