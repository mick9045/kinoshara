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
	 * @author Julia
	 * @param genre
	 * @return
	 */
	@Query("select f from Film f join f.genres g where g.name = :genre")
	List<Film> findByGenres(@Param("genre")String genre);
	/**
	 * @author Azavoruyev
	 * @param search by contains
	 * @return
	 */
	@Query("select b from Film b where lower(b.title) like %:title%")
	   List<Film>  searchFilmsByName(@Param("title") String name);
}
