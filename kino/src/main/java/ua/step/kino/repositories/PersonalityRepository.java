package ua.step.kino.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.step.kino.entities.Genre;
import ua.step.kino.entities.Personality;
import ua.step.kino.entities.Position;

public interface PersonalityRepository extends JpaRepository<Personality, Integer> {
	
	List<Personality> findByPositions(Position position);
}
