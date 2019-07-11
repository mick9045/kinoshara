package ua.step.kino.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.step.kino.entities.Country;
import ua.step.kino.repositories.CountryRepository;

@Service
public class CountryServiceImpl implements CountryService {
	@Autowired CountryRepository countryRepository;
	
	@Override
	public List<Country> getAll() {
		return countryRepository.findAll();
	}

}
