package ua.step.kino.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	@Autowired
	CountryRepository countryRepository;

	@GetMapping
	public String showAll(Model model) {
		List<Country> countries = countryRepository.findAll();
		model.addAttribute("countries", countries);
		return "countries";
	}

	@GetMapping("/add")
	public String showAddForm(Country country) {
		return "country-add";
	}

	@PostMapping("/add")
	public String addEntity(@Valid Country country, @RequestParam Optional<String> error, BindingResult result, Model model) {
		if (countryRepository.findByName(country.getName().toLowerCase()) != null) {
			model.addAttribute("error", "This country is already exist!");
			return "country-add";
		}
		if (result.hasErrors()) {
			return "country-add";
		}
		countryRepository.save(country);
		return "redirect:/countries";
	}

	@GetMapping("/edit/{id}")
	public String showUpdateForm(@PathVariable("id") int id, Model model) {
		Country country = countryRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));

		model.addAttribute("country", country);
		return "country-edit";
	}

	@PostMapping("/edit/{id}")
	public String updateEntity(@PathVariable("id") int id, @RequestParam Optional<String> error, @Valid Country country, BindingResult result, Model model) {
		if (countryRepository.findByName(country.getName().toLowerCase()) != null) {
			model.addAttribute("error", "This country is already exist!");
			return "country-edit";
		}
		if (result.hasErrors()) {
			country.setId(id);
			return "country-edit";
		}

		countryRepository.save(country);
		return "redirect:/countries";
	}

	@GetMapping("/delete/{id}")
	public String deleteEntity(@PathVariable("id") int id, Model model) {
		Country country = countryRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
		countryRepository.delete(country);
		return "redirect:/countries";
	}
}
