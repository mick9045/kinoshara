package ua.step.kino.controllers.admin;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ua.step.kino.dto.PersonalityDTO;
import ua.step.kino.entities.Country;
import ua.step.kino.repositories.CountryRepository;

@Controller
@RequestMapping("admin/edit/country")
public class EditCountryController {
	@Autowired
	CountryRepository countryRepo;
	
	@GetMapping("/{id}")
	//@Secured("ROLE_ADMIN")
	String get(@PathVariable int id, Model model)
	{
		countryRepo.findById(id).ifPresent(country -> model.addAttribute("contr", country));
		return "admin/pages/edit_country";
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.POST)
	String add(@ModelAttribute Country contr, Errors errors, RedirectAttributes redir)
	{
		
		if (!errors.hasErrors()) {
			countryRepo.save(contr);
			//model.addAttribute("result", "success");
			redir.addFlashAttribute("result", "success");
		} else {
			//model.addAttribute("result", "fail");
			redir.addFlashAttribute("result", "fail");
		}
		
		return "redirect:/admin/add/person";
	}
}
