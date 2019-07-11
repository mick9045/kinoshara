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
    @NotEmpty
    @Size(min=2, max=30)
	private String firstname;

	@NotNull
    @NotEmpty
    @Size(min=2, max=60)
	private String lastname;
	
    @Size(max=15)
	private String country;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date birthday;
	
    @Size(max=1024)
	@Column(columnDefinition="TEXT")
	private String biography;
	
	private List<Position> positions;
	
	private MultipartFile photo;

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
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
