package ua.step.kino.entities;

import java.sql.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 
 * @author Kojevin
 *
 */
@Entity
@Table(name = "actors")
public class Actor {
	
	/*
	 * fields
	 */
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String firstName;
	
	private String lastName;
	
	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date dateOfBirthday;
	
	@Column(columnDefinition="TEXT")
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
	
	/*
	 * functions
	 */
	
	public Actor()
	{
		
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
