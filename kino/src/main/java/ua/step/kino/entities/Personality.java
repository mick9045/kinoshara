package ua.step.kino.entities;

import java.sql.Date;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;


import com.fasterxml.jackson.annotation.JsonFormat;

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Entity(name = "personalities")
public class Personality {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	//@JoinTable(name = "personality_position", joinColumns = @JoinColumn(name = "personality_id"))
	@ElementCollection(targetClass = Position.class)
	@Column(name = "position", nullable = false)
	@Enumerated(EnumType.STRING)
	@CollectionTable(name="person_interest")
	private List<Position> positions;
	
	
	private String firstName;
	
	private String lastName;
	
	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date dateOfBirthday;
	
	private String biography;
	
	private String photo;
	
	@ManyToOne
	@JoinColumn(name="country_id")
	private Country country;
	
	@ManyToMany
	@JoinTable(
			  name = "Actors_Films", 
			  joinColumns = @JoinColumn(name = "actor_id"), 
			  inverseJoinColumns = @JoinColumn(name = "films_id"))
	private List<Film> films;
	
	public Personality()
	{
	}
	
	/*
	 * functions
	 */
	
	public List<Position> getPositions() {
		return positions;
	}

	public void setPositions(List<Position> positions) {
		this.positions = positions;
	}

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDateOfBirthday() {
		return dateOfBirthday;
	}

	public void setDateOfBirthday(Date dateOfBirthday) {
		this.dateOfBirthday = dateOfBirthday;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public List<Film> getFilms() {
		return films;
	}

	public void setFilms(List<Film> films) {
		this.films = films;
	}
	

	public String getBiography() {
		return biography;
	}

	public void setBiography(String biography) {
		this.biography = biography;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
}
