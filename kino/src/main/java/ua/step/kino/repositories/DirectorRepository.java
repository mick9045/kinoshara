package ua.step.kino.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.step.kino.entities.Director;
/**
 * 
 * @author AZavoruyev
 *
 */


public interface DirectorRepository extends JpaRepository<Director, Integer>{
//поиск режисера по имени
	 @Query("select b from Director b where b.name = :name")
	 Director findByName(@Param("name") String name);
	//поиск режисера по фрагменту имени
	  @Query("select b from Director b where b.name like %:name%")
	  List<Director> findNameContains(@Param("name") String name);
}
