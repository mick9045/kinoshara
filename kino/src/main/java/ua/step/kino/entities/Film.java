package ua.step.kino.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
	// TODO убрать нафиг релиз йер
	private int releaseYear;
	
	private int views;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	@JoinTable(
		     name = "Directors_Films", 
		     joinColumns = @JoinColumn(name = "films_id"), 
		     inverseJoinColumns = @JoinColumn(name = "director_id"))
	private Set<Director> directors = new HashSet<Director>();

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	@JoinTable(
	     name = "Actors_Films", 
	     joinColumns = @JoinColumn(name = "films_id"), 
	     inverseJoinColumns = @JoinColumn(name = "actor_id"))
	 private Set<Actor> actors = new HashSet<Actor>();
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Genre> genres = new HashSet<Genre>();
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Country> countries = new ArrayList<Country>();
	
	
	private String imageSmallPath;
	private String posterBig;
	
	@Temporal(javax.persistence.TemporalType.TIMESTAMP)
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date releaseDate;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date additionalDate;
	
	@JsonIgnore
	private Double rating;
	@JsonIgnore
	private Double filmLength;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "film")
	private Set<Comment> comments = new HashSet<>();
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "film")
	private Set<Review> reviews = new HashSet<>();
	//==============================Fields==============================================
	
	public Film() {

	}
	
	public Film(int id, String title, Set<Director> directors, Set<Actor> actors, Set<Genre> genres,
			List<Country> countries, String posterSmall, String posterBig, Date releaseDate, Double rating,
			Double filmLength, Set<Comment> comments, Set<Review> reviews, int views, Date additionalDate) {
		super();
		this.id = id;
		this.title = title;
		this.directors = directors;
		this.actors = actors;
		this.genres = genres;
		this.countries = countries;
		this.imageSmallPath = posterSmall;
		this.posterBig = posterBig;
		this.releaseDate = releaseDate;
		this.rating = rating;
		this.filmLength = filmLength;
		this.comments = comments;
		this.reviews = reviews;
		this.views = views;
		this.setAdditionalDate(additionalDate);
	}

	public String getImageSmallPath() {
		return imageSmallPath;
	}

	public void setImageSmallPath(String imageSmallPath) {
		this.imageSmallPath = imageSmallPath;
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

	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Comment comments) {
		this.comments.add(comments);
	}

	public Set<Review> getReviews() {
		return reviews;
	}

	public void setReviews(Review reviews) {
		this.reviews.add(reviews);
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

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	public Date getAdditionalDate() {
		return additionalDate;
	}

	public void setAdditionalDate(Date additionlDate) {
		this.additionalDate = additionlDate;
	}
	
	
	

}
