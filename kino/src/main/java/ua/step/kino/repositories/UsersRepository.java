package ua.step.kino.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.step.kino.entities.User;

public interface UsersRepository extends JpaRepository<User, Integer> {
	
	@Query("select b from User b where b.email = :email")
	User findByEmail(@Param("email") String email);

	@Query("select b from User b where b.login = :login")
	User findByLogin(@Param("login") String login);
	
	 @Modifying
	    @Query("update User u set u.password = :password where u.id = :id")
	    void updatePassword(@Param("password") String password, @Param("id") int id);
	 
	 @Modifying
	    @Query("update User u set u.avatar = :imageName where u.id = :id")
	    void updateAvatar(@Param("imageName") String imageName, @Param("id") int id);

}
