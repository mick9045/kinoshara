package ua.step.kino.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.step.kino.entities.Country;
import ua.step.kino.entities.Genre;

/**
 * 
 * @author mick
 *
 */
public interface CountryRepository extends JpaRepository<Country, Integer> {
	@Query("select c from Country c where lower(c.name) = :name")
	Country findByName(@Param("name") String name);
}
