package ua.step.kino.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.step.kino.entities.Actor;

/**
 * 
 * @author Kojevin
 *
 */

public interface ActorRepository extends JpaRepository<Actor, Integer>
{
	
}
