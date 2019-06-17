package ua.step.kino.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * 
 * @author AZavoruyev
 *
 */
@Entity
@Table(name = "directors")
public class Director {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "author_id", unique = true, nullable = false)
	private Long id;

	private String name;
	
}
