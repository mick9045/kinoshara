package ua.step.kino.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.step.kino.entities.Role;

/**
 * 
 * @author bas
 *
 */

public interface RolesRepository extends JpaRepository<Role, Integer> {
}
