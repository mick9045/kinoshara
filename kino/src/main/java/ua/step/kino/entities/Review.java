package ua.step.kino.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
/**
 * 
 * @author AZavoruyev
 *
 */
//Рецензия
@Entity
@Table(name = "reviews")
public class Review {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="USER_ID")
	private User user;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="film_id")
	private Film film;
	
	private Boolean isGood;
	
	private String review;
	
	public Review() {
//		super();
	}
	public Review(User user, Film film, Boolean isGood, String review) {
//		super();
//		this.id = id;
		this.setUser(user);
		this.setFilm(film);
		this.setIsGood(isGood);
		this.setReview(review);
	}

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Film getFilm() {
		return film;
	}
	public void setFilm(Film film) {
		this.film = film;
	}
	public Boolean getIsGood() {
		return isGood;
	}
	public void setIsGood(Boolean isGood) {
		this.isGood = isGood;
	}

}
