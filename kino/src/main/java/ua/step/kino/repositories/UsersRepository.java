package ua.step.kino.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.step.kino.entities.User;

public interface UsersRepository extends JpaRepository<User, Integer> {
	
	@Query("select b from User b where b.email = :email")
	User findByEmail(@Param("email") String email);

	@Query("select b from User b where b.login = :login")
	User findByLogin(@Param("login") String login);

}
