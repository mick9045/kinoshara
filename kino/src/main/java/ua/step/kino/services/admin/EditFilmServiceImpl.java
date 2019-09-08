package ua.step.kino.services.admin;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.step.kino.dto.FilmDTO;
import ua.step.kino.entities.Film;
import ua.step.kino.entities.Personality;
import ua.step.kino.repositories.CountryRepository;
import ua.step.kino.repositories.FilmRepository;
import ua.step.kino.repositories.GenreRepository;
import ua.step.kino.repositories.PersonalityRepository;
import ua.step.kino.services.UploadService;

@Service
public class EditFilmServiceImpl implements EditFilmService{

	@Autowired
	FilmRepository filmRepo;
	
	@Autowired UploadService uploadService;
	
	@Autowired 
	PersonalityRepository personalRepository;
	
	@Autowired
	CountryRepository countryRepository;
	
	@Autowired
	GenreRepository genreRepository;
	
	@Override
	public Boolean add(FilmDTO filmDTO, int id) {
		
		String imageName = "";
		if(!filmDTO.getPosterBig().isEmpty()) {
			String originalFileName = filmDTO.getPosterBig().getOriginalFilename();
			imageName = FilenameUtils.removeExtension(originalFileName);
			imageName += "_";
			imageName += UUID.randomUUID().toString();
			imageName += "." + FilenameUtils.getExtension(originalFileName);
			
			if (uploadService.uploadBigPoster(filmDTO.getPosterBig(), imageName) != 200) {
				System.out.println("failed image load");
				return false;
			}
			
			if (uploadService.uploadSmallPoster(filmDTO.getPosterBig(), imageName) != 200) {
				System.out.println("failed image load");
				return false;
			}
		}
		
		Film film = filmRepo.getOne(id);
		
		Set<Personality> actors = new HashSet<Personality>();
		
		if (filmDTO.getActors() != null) {
			filmDTO.getActors().stream().forEach(integer -> {
				personalRepository.findById(integer).ifPresent(person -> {
					actors.add(person);
				});
			});
		}
		
		film.setActors(actors);
		
		if (filmDTO.getDirectors() != null) {
			film.setDirectors(personalRepository.findAllById(filmDTO.getDirectors()));
		}

		if (filmDTO.getCountries() != null) {
			film.setCountries(countryRepository.findAllById(filmDTO.getCountries()));
		}

		if (filmDTO.getGenres() != null) {
			film.setGenres(genreRepository.findAllById(filmDTO.getGenres()));
		}
		film.setTitle(filmDTO.getTitle());
		film.setReleaseDate(filmDTO.getReleaseDate());
		film.setRating(filmDTO.getRating());
		film.setFilmLength(filmDTO.getFilmLength());
		
		film.setPosterBig(imageName);
		film.setImageSmallPath(imageName);
		
		filmRepo.save(film);
		return true;
	}

}
