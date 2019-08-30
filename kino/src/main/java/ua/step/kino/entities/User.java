package ua.step.kino.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	@Column(nullable = false)
	private String login;
	@Column(nullable = false)
	private String password;
	@DateTimeFormat(pattern = "dd.MM.yyyy")
    private LocalDate birthday;
    @Column(nullable = false)
    private String email;
    
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="ROLE_ID")
    private Role role;
    
    @Column(nullable = false)
    private boolean enabled;
    
    /**
     * 
     * @author AZavoruyev
     *
     */
    
	/*
	 * private String firstName;
	 * 
	 * private String lastName;
	 */

	private String avatar;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	@JoinTable(
			  name = "Users_Films_To_Watch", 
			  joinColumns = @JoinColumn(name = "user_id"), 
			  inverseJoinColumns = @JoinColumn(name = "films_id"))
	private List<Film> filmsToWatch= new ArrayList<Film>();
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	@JoinTable(
			  name = "Users_Films_Watched", 
			  joinColumns = @JoinColumn(name = "user_id"), 
			  inverseJoinColumns = @JoinColumn(name = "films_id"))
	private List<Film> filmsWatched= new ArrayList<Film>();
	

	public User() {
		super();
		this.enabled = false;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}
	public void setBirthday(String birthday) {
		LocalDate date = LocalDate.parse(birthday);
		this.birthday = date;
	}
	
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	/*
	 * public String getFirstName() { return firstName; }
	 * 
	 * public void setFirstName(String firstName) { this.firstName = firstName; }
	 * 
	 * public String getLastName() { return lastName; }
	 * 
	 * public void setLastName(String lastName) { this.lastName = lastName; }
	 */

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public List<Film> getFilmsToWatch() {
		return filmsToWatch;
	}

	public void setFilmsToWatch(List<Film> filmsToWatch) {
		this.filmsToWatch = filmsToWatch;
	}

	public List<Film> getFilmsWatched() {
		return filmsWatched;
	}

	public void setFilmsWatched(List<Film> filmsWatched) {
		this.filmsWatched = filmsWatched;
	}


	
}
