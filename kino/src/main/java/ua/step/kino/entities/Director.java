package ua.step.kino.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;



/**
 * 
 * @author AZavoruyev
 *
 */
@Entity
@Table(name = "directors")
public class Director implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@Column(name = "director_id", unique = true, nullable = false)
	private int id;

	private String name;

//	@Temporal(javax.persistence.TemporalType.DATE)
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate birthday;

	@ManyToOne
	@JoinColumn(name="country_id")
	private Country country;

	@ManyToMany
	private List<Film> films;

	public Director() {

	}

	public Director(String name, LocalDate birthday, Country country) {
		this.setName(name);
		this.setBirthday(birthday);
		this.setCountry(country);
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country contry) {
		this.country = contry;
	}
	
	public List<Film> getFilms() {
		return films;
	}

	public void setFilms(List<Film> films) {
		this.films = films;
	}
	
	public void addFilm(Film film) {
		this.films.add(film);
	}
}