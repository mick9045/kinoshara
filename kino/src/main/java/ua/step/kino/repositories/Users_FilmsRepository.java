package ua.step.kino.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import ua.step.kino.entities.Users_Films;
/**
 * 
 * @author AZavoruyev
 *
 */
public interface Users_FilmsRepository extends JpaRepository<Users_Films, Integer> {
	@Query("from Users_Films uf inner join uf.user u inner join uf.film f where u.id = :userId AND f.id = :filmId" )
	Users_Films findByFilmAndUserId(@Param("userId")Integer userId, @Param("filmId")Integer filmId);
	
	@Modifying
    @Query("update Users_Films uf set uf.status = :status where uf.id = :id")
    void updateStatus(@Param("status") int status, @Param("id") int id);
	
	@Query("from Users_Films uf inner join uf.user u inner join uf.film f where u.id = :userId AND uf.status = :status" )
	List<Users_Films> findByStatus(@Param("userId")Integer userId, @Param("status")Integer status);
	
	  @Modifying
	   @Query("delete from Users_Films uf where uf.film.id = :filmId")
	    void deleteByFilm(@Param("filmId")Integer filmId);
	  
	 	}
