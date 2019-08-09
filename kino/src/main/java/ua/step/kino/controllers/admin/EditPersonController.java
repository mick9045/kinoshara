package ua.step.kino.controllers.admin;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ua.step.kino.dto.PersonalityDTO;
import ua.step.kino.repositories.CountryRepository;
import ua.step.kino.repositories.PersonalityRepository;
import ua.step.kino.services.admin.PersonalityEditService;
import ua.step.kino.services.admin.PersonalityToDTOServiceImpl;

@Controller
@RequestMapping("admin/edit/person")
public class EditPersonController {
	
	@Autowired
	PersonalityRepository personRepo;
	
	@Autowired
	PersonalityToDTOServiceImpl toDTO;
	
	@Autowired
	CountryRepository countryRepo;
	
	@Autowired
	PersonalityEditService pEditService;
	
	@GetMapping("/{id}")
	//@Secured("ROLE_ADMIN")
	String get(@PathVariable int id, Model model)
	{
		personRepo.findById(id).ifPresent(per -> model.addAttribute("person", per));
		model.addAttribute("countries", countryRepo.findAll());
		model.addAttribute("posii", 1);
		return "admin/pages/edit_person";
		//return toDTO.transform(personRepo.findById(id).orElseThrow(() -> new RuntimeException("Error")));
	}
	
	@PostMapping("/{id}")
	String add(@PathVariable int id, @Valid PersonalityDTO personality, Model model, Errors errors, RedirectAttributes redir)
	{
		
		if (!errors.hasErrors() && pEditService.add(personality, id)) {
			//model.addAttribute("result", "success");
			redir.addFlashAttribute("result", "success");
		} else {
			//model.addAttribute("result", "fail");
			redir.addFlashAttribute("result", "fail");
		}
		
		return "redirect:/admin/add/person";
	}
}
