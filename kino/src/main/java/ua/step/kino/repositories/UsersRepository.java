package ua.step.kino.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.step.kino.entities.User;

public interface UsersRepository extends JpaRepository<User, Integer> {

}
