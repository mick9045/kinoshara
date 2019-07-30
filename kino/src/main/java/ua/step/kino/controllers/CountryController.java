package ua.step.kino.controllers;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.step.kino.entities.Country;
import ua.step.kino.repositories.CountryRepository;

/**
 * 
 * @author mick
 *
 */

@Controller
@RequestMapping("/countries")
public class CountryController {
	@Autowired CountryRepository countryRepository;
	
	@GetMapping
	public String showAll(Model model) {
		List<Country> countries = countryRepository.findAll();
		model.addAttribute("countries", countries);
		return "countries";
	}
	
	@GetMapping("/add")
    public String showAddForm(Country countrie) {
        return "add-countrie";
    }
     
    @PostMapping("/add")
    public String addEntity(@Valid Country country, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-countrie";
        }
         
        countryRepository.save(country);
        List<Country> countries = countryRepository.findAll();
		model.addAttribute("countries", countries);
		return "countries";
    }
	
	@GetMapping("/edit/{id}")
	public String showUpdateForm(@PathVariable("id") int id, Model model) {
		Country country = countryRepository.findById(id)
	      .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
	     
	    model.addAttribute("country", country);
	    return "update-country";
	}
	
	@PostMapping("/edit/{id}")
	public String updateEntity(@PathVariable("id") int id, @Valid Country country, 
	  BindingResult result, Model model) {
	    if (result.hasErrors()) {
	    	country.setId(id);
	        return "update-country";
	    }
	         
	    countryRepository.save(country);
        List<Country> countries = countryRepository.findAll();
		model.addAttribute("countries", countries);
		return "countries";
	}
	     
	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id") int id, Model model) {
		Country country = countryRepository.findById(id)
	      .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
		countryRepository.delete(country);
		List<Country> countries = countryRepository.findAll();
		model.addAttribute("countries", countries);
		return "countries";
	}
}
