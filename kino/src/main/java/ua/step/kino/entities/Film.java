package ua.step.kino.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 
 * @author Aleksey
 *
 */

@Entity
@Table(name = "films")
public class Film {
	
	//==============================Fields==============================================
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String title;
	
	private String imageSmallPath;
	
	private int releaseYear;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(
		     name = "Directors_Films", 
		     joinColumns = @JoinColumn(name = "films_id"), 
		     inverseJoinColumns = @JoinColumn(name = "director_id"))
	private Set<Director> directors = new HashSet<Director>();

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(
	     name = "Actors_Films", 
	     joinColumns = @JoinColumn(name = "films_id"), 
	     inverseJoinColumns = @JoinColumn(name = "actor_id"))
	 private Set<Actor> actors = new HashSet<Actor>();
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Genre> genres = new HashSet<Genre>();
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Country> countries = new ArrayList<Country>();
	
	
	private String posterSmall;
	private String posterBig;
	
	@Temporal(javax.persistence.TemporalType.TIMESTAMP)
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date releaseDate;
	private Double rating;
	private Double filmLength;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Comment> comments = new ArrayList<Comment>();
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Review> reviews = new ArrayList<Review>();
	//==============================Fields==============================================
	
	public Film() {

	}
	
	public Film(int id, String title, Set<Director> directors, Set<Actor> actors, Set<Genre> genres,
			List<Country> countries, String posterSmall, String posterBig, Date releaseDate, Double rating,
			Double filmLength, List<Comment> comments, List<Review> reviews) {
		super();
		this.id = id;
		this.title = title;
		this.directors = directors;
		this.actors = actors;
		this.genres = genres;
		this.countries = countries;
		this.posterSmall = posterSmall;
		this.posterBig = posterBig;
		this.releaseDate = releaseDate;
		this.rating = rating;
		this.filmLength = filmLength;
		this.comments = comments;
		this.reviews = reviews;
	}

	public String getPosterSmall() {
		return posterSmall;
	}

	public void setPosterSmall(String posterSmall) {
		this.posterSmall = posterSmall;
	}

	public String getPosterBig() {
		return posterBig;
	}

	public void setPosterBig(String posterBig) {
		this.posterBig = posterBig;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public double getFilmLength() {
		return filmLength;
	}

	public void setFilmLength(Double filmLength) {
		this.filmLength = filmLength;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getImageSmallPath() {
		return imageSmallPath;
	}

	public void setImageSmallPath(String imageSmallPath) {
		this.imageSmallPath = imageSmallPath;
	}
	
	public int getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	public Set<Director> getDirectors() {
		return directors;
	}

	public void setDirectors(Set<Director> directors) {
		this.directors = directors;
	}

	public Set<Actor> getActors() {
		return actors;
	}

	public void setActors(Set<Actor> actors) {
		this.actors = actors;
	}

	public Set<Genre> getGenres() {
		return genres;
	}

	public void setGenres(Set<Genre> genres) {
		this.genres = genres;
	}

	public List<Country> getCountries() {
		return countries;
	}

	public void setCountries(List<Country> countries) {
		this.countries = countries;
	}
	
	
	

}
