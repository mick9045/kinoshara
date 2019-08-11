package ua.step.kino.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "user_details")
public class UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	 @OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
	    @JoinColumn(nullable = false, name = "user_id")
	private User user;

	private String firstName;

	private String lastName;

	private String avatar;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "country_id")
	private Country country;

	public UserDetails(User user) {
		this.setUser(user);
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}
}
