package ua.step.kino.dto;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

public class FilmDTO {
	@NotNull
	@NotEmpty
	@Size(min = 1, max = 64)
	private String title;

	// private int views;

	@Size(min = 1, max = 20)
	private List<Integer> directors;

	@Size(min = 1, max = 100)
	private List<Integer> actors;

	@Size(min = 1, max = 10)
	private List<Integer> genres;

	@Size(min = 1, max = 5)
	private List<Integer> countries;

	private MultipartFile posterBig;

	private MultipartFile posterSmall;

	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date releaseDate;

	// @DateTimeFormat(pattern="yyyy-MM-dd")
	// private Date additionalDate;

	private Double rating;

	@NotNull
	private Double filmLength;
	
	@Size(max=1024)
	@Column(columnDefinition="TEXT")
	private String description;

	public FilmDTO() {

	}

	public FilmDTO(@NotNull @NotEmpty @Size(min = 1, max = 64) String title,
			@NotNull @NotEmpty @Size(min = 1, max = 1024) String description,
			@NotNull @NotEmpty @Size(min = 1, max = 20) List<Integer> directors,
			@NotNull @NotEmpty @Size(min = 1, max = 100) List<Integer> actors,
			@NotNull @NotEmpty @Size(min = 1, max = 10) List<Integer> genres,
			@NotNull @NotEmpty @Size(min = 1, max = 5) List<Integer> countries,
			@NotNull @NotEmpty MultipartFile posterBig, MultipartFile posterSmall, @NotNull @NotEmpty Date releaseDate,
			Date additionalDate, @NotNull @NotEmpty Double rating, @NotNull @NotEmpty Double filmLength) {
		super();
		this.title = title;
		this.setDescription(description);
		// this.releaseYear = releaseYear;
		// this.views = views;
		this.directors = directors;
		this.actors = actors;
		this.genres = genres;
		this.countries = countries;
		this.posterBig = posterBig;
		this.posterSmall = posterSmall;
		this.releaseDate = releaseDate;
		this.rating = rating;
		this.filmLength = filmLength;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Integer> getDirectors() {
		return directors;
	}

	public void setDirectors(List<Integer> directors) {
		this.directors = directors;
	}

	public List<Integer> getActors() {
		return actors;
	}

	public void setActors(List<Integer> actors) {
		this.actors = actors;
	}

	public List<Integer> getGenres() {
		return genres;
	}

	public void setGenres(List<Integer> genres) {
		this.genres = genres;
	}

	public List<Integer> getCountries() {
		return countries;
	}

	public void setCountries(List<Integer> countries) {
		this.countries = countries;
	}

	public MultipartFile getPosterBig() {
		return posterBig;
	}

	public void setPosterBig(MultipartFile posterBig) {
		this.posterBig = posterBig;
	}

	public MultipartFile getPosterSmall() {
		return posterSmall;
	}

	public void setPosterSmall(MultipartFile posterSmall) {
		this.posterSmall = posterSmall;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public Double getFilmLength() {
		return filmLength;
	}

	public void setFilmLength(Double filmLength) {
		this.filmLength = filmLength;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
