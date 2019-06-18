package ua.step.kino.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

	@Temporal(javax.persistence.TemporalType.DATE)
	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date dateOfBirth;

	private Country contryOfOrigin;

	@OneToMany(mappedBy = "director")
	private List<Film> filmography;

	// для класса Film
	// @ManyToOne
	// private Director director = new Director();

	public Director() {

	}

	public Director(String name, Date dateOfBirth, Country contryOfOrigin) {
		this.setName(name);
		this.setDateOfBirth(dateOfBirth);
		this.setContryOfOrigin(contryOfOrigin);
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

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Country getContryOfOrigin() {
		return contryOfOrigin;
	}

	public void setContryOfOrigin(Country contryOfOrigin) {
		this.contryOfOrigin = contryOfOrigin;
	}
	
	public List<Film> getFilmography() {
		return filmography;
	}

	public void setFilmography(List<Film> filmography) {
		this.filmography = filmography;
	}
	
	public void addFilm(Film film) {
		this.filmography.add(film);
	}
}
