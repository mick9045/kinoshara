package ua.step.kino.services.admin;

import java.util.HashSet;

import java.util.Set;
import java.util.UUID;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.apache.commons.lang3.StringUtils;

import ua.step.kino.dto.FilmDTO;
import ua.step.kino.entities.Film;
import ua.step.kino.entities.Genre;
import ua.step.kino.entities.Personality;
import ua.step.kino.repositories.CountryRepository;
import ua.step.kino.repositories.FilmRepository;
import ua.step.kino.repositories.GenreRepository;
import ua.step.kino.repositories.PersonalityRepository;
import ua.step.kino.services.UploadService;


@Service
public class AddFilmServiceImpl implements AddFilmService{
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
	public Boolean add(FilmDTO filmDTO) {
		String imageName = "";
		if(!filmDTO.getPosterBig().isEmpty())
		{
			String originalFileName = filmDTO.getPosterBig().getOriginalFilename();
			imageName = FilenameUtils.removeExtension(originalFileName);
			imageName += "_";
			imageName += UUID.randomUUID().toString();
			imageName += "." + FilenameUtils.getExtension(originalFileName);
			
			if (uploadService.uploadBigPoster(filmDTO.getPosterBig(), imageName) != 200)
			{
				System.out.println("failed image load");
				return false;
			}
			
			if (uploadService.uploadSmallPoster(filmDTO.getPosterBig(), imageName) != 200)
			{
				System.out.println("failed image load");
				return false;
			}
		}
		
		
		Film newFilm = new Film();
		
		Set<Personality> actors = new HashSet<Personality>();
		
		if (filmDTO.getActors() != null) {
			filmDTO.getActors().stream().forEach(integer -> {
				personalRepository.findById(integer).ifPresent(person -> {
					actors.add(person);
				});
			});
		}
		
		newFilm.setActors(actors);
		
		if (filmDTO.getDirectors() != null) {
			newFilm.setDirectors(personalRepository.findAllById(filmDTO.getDirectors()));
		}

		if (filmDTO.getCountries() != null) {
			newFilm.setCountries(countryRepository.findAllById(filmDTO.getCountries()));
		}

		if (filmDTO.getGenres() != null) {
			newFilm.setGenres(genreRepository.findAllById(filmDTO.getGenres()));
		}
		newFilm.setTitle(filmDTO.getTitle());
		newFilm.setDescription(filmDTO.getDescription());
		newFilm.setReleaseDate(filmDTO.getReleaseDate());
		newFilm.setFilmLength(filmDTO.getFilmLength());
		
		newFilm.setPosterBig(imageName);
		newFilm.setImageSmallPath(imageName);
		
		if(filmDTO.getImdbRef() != null) {
			newFilm.setImbdRef(StringUtils.strip(filmDTO.getImdbRef(), "/"));
		}
		filmRepo.save(newFilm);
		
		
		return true;
	}

}
