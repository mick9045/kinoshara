package ua.step.kino.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.step.kino.entities.Country;

/**
 * 
 * @author mick
 *
 */
public interface CountryRepository extends JpaRepository<Country, Integer> {
}
