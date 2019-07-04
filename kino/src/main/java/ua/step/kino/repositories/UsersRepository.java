package ua.step.kino.repositories;

import org.jboss.logging.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ua.step.kino.entities.User;

public interface UsersRepository extends JpaRepository<User, Integer> {
	
	@Query("select b from User b where b.email = :email")
	User findByEmail(String email);

	@Query("select b from User b where b.login = :login")
	User findByLogin(String login);

}
