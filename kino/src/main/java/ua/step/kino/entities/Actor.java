package ua.step.kino.entities;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "actors")

@DiscriminatorValue("1")
public class Actor extends Personality {
	/*
	@ManyToMany
	@JoinTable(
			  name = "Actors_Films", 
			  joinColumns = @JoinColumn(name = "actor_id"), 
			  inverseJoinColumns = @JoinColumn(name = "films_id"))
	private List<Film> films;
	
	public List<Film> getFilms() {
		return films;
	}

	public void setFilms(List<Film> films) {
		this.films = films;
	}
	*/
	
}
