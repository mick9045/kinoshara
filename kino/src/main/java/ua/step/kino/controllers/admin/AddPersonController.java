package ua.step.kino.controllers.admin;

import java.util.Date;
import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import ua.step.kino.dto.PersonalityDTO;
import ua.step.kino.entities.Personality;
import ua.step.kino.services.CountryService;
import ua.step.kino.services.admin.PersonalityService;

@Controller
@RequestMapping("/admin/add/person")
public class AddPersonController {
	@Autowired
	PersonalityService personalityService;
	
	@Autowired 
	CountryService countryService;

	@GetMapping
	@RolesAllowed("ROLE_ADMIN")
	String add(Model model) {
		model.addAttribute("countries", countryService.getAll());
		return "admin/pages/add_person";
	}
	
	@PostMapping
	@Secured("ROLE_ADMIN")
	//String post(@RequestParam("photo") MultipartFile file, @RequestParam String firstname, @RequestParam String lastname, @RequestParam String[] positions, @RequestParam String country, @RequestParam @DateTimeFormat(pattern="yyyy-MM-dd") Date birthday, @RequestParam String biography, Model model) {
	String post(@Valid PersonalityDTO personality, Model model) {
		System.out.println("addition");
		if (personalityService.add(personality)) {
			model.addAttribute("result", "success");
		} else {
			model.addAttribute("result", "fail");
		}
		return "redirect:admin/pages/add_person";
	}
}
