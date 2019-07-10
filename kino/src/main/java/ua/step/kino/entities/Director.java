package ua.step.kino.entities;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "directors")

@DiscriminatorValue("2")
public class Director extends Personality {
	@ManyToMany
	@JoinTable(
			  name = "Directors_Films", 
			  joinColumns = @JoinColumn(name = "director_id"), 
			  inverseJoinColumns = @JoinColumn(name = "films_id"))
	private List<Film> films;
	
	public List<Film> getFilms() {
		return films;
	}

	public void setFilms(List<Film> films) {
		this.films = films;
	}
	
}