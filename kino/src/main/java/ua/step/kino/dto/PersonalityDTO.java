package ua.step.kino.dto;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import ua.step.kino.entities.Position;

public class PersonalityDTO {
	@NotNull
	private int id;
	
	@NotNull
    @NotEmpty
    @Size(min=2, max=30)
	private String firstName;

	@NotNull
    @NotEmpty
    @Size(min=2, max=60)
	private String lastName;
	
    @Size(max=15)
	private String country;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date birthday;
	
    @Size(max=1024)
	@Column(columnDefinition="TEXT")
	private String biography;
	
	private List<Position> positions;
	
	private MultipartFile photo;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstname) {
		this.firstName = firstname;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastname) {
		this.lastName = lastname;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getBiography() {
		return biography;
	}

	public void setBiography(String biography) {
		this.biography = biography;
	}

	public List<Position> getPositions() {
		return positions;
	}

	public void setPositions(List<Position> positions) {
		this.positions = positions;
	}

	public MultipartFile getPhoto() {
		return photo;
	}

	public void setPhoto(MultipartFile photo) {
		this.photo = photo;
	}

	
}
