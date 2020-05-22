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
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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

	@Column(columnDefinition="TEXT")
	private String description;
	
	private String imdbRef;
	
	private int views;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	@JoinTable(
		     name = "Directors_Films", 
		     joinColumns = @JoinColumn(name = "films_id"), 
		     inverseJoinColumns = @JoinColumn(name = "director_id"))
	private List<Personality> directors = new ArrayList<Personality>();

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	@JoinTable(
	     name = "Actors_Films", 
	     joinColumns = @JoinColumn(name = "films_id"), 
	     inverseJoinColumns = @JoinColumn(name = "actor_id"))
	 private Set<Personality> actors = new HashSet<Personality>();
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Genre> genres = new ArrayList<Genre>();
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Country> countries = new ArrayList<Country>();
	
	
	private String imageSmallPath;
	private String posterBig;
	
	@Temporal(javax.persistence.TemporalType.TIMESTAMP)
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date releaseDate;
	
	@JsonIgnore
	private Double rating;
	@JsonIgnore
	private Double filmLength;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "film")
	@JsonIgnore
	private Set<Comment> comments = new HashSet<>();
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "film")
	@JsonIgnore
	private Set<Review> reviews = new HashSet<>();
	//==============================Fields==============================================
	
	public Film() {

	}
	
	public Film(int id, String title, List<Personality> directors, Set<Personality> actors, List<Genre> genres,
			List<Country> countries, String posterSmall, String posterBig, Date releaseDate, Double rating,
			Double filmLength, Set<Comment> comments, Set<Review> reviews, int views, String description, String imdbRef) {
		super();
		this.id = id;
		this.title = title;
		this.setDescription(description);
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
		this.imdbRef = imdbRef;
		
		//this.setAdditionalDate(additionalDate);
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
	

	public List<Personality> getDirectors() {
		return directors;
	}

	public void setDirectors(List<Personality> list) {
		this.directors = list;
	}

	public Set<Personality> getActors() {
		return actors;
	}

	public void setActors(Set<Personality> actors2) {
		this.actors = actors2;
	}

	public List<Genre> getGenres() {
		return genres;
	}

	public void setGenres(List<Genre> list) {
		this.genres = list;
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


	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getImdbRef() {
		return imdbRef;
	}

	public void setImbdRef(String imdbRef) {
		this.imdbRef = imdbRef;
	}
	
	public String getImdbId()
	{
		if(this.imdbRef != null)
		{
			 String[] imdbRefPathParts = this.imdbRef.split("/");
			 if(imdbRefPathParts.length > 0) {
				 return imdbRefPathParts[imdbRefPathParts.length-1];
			 }
			 
		}
		
		return "";
	}
	
}
