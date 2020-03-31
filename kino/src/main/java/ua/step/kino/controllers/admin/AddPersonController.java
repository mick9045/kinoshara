package ua.step.kino.controllers.admin;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.annotation.security.RolesAllowed;
import javax.swing.text.Position;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ua.step.kino.dto.PersonalityDTO;
import ua.step.kino.entities.Personality;
import ua.step.kino.services.CountryService;
import ua.step.kino.services.admin.PersonalityService;
import ua.step.kino.services.util.UtilService;

@Controller
@RequestMapping("admin/add/person")
public class AddPersonController {
	@Autowired
	PersonalityService personalityService;
	
	@Autowired 
	CountryService countryService;
	
	@Autowired
	UtilService utilService;

	@GetMapping(value = { "", "{position}" })
	@Secured("ROLE_ADMIN")
	String add(
			@PathVariable(name = "position") Optional<String> position,
			Model model) {
		model.addAttribute("countries", countryService.getAll());
		position
			.ifPresent(pos -> model.addAttribute("preselectedPosition", utilService.searchEnum(ua.step.kino.entities.Position.class, pos)));
		
		return "admin/pages/add_person";
	}
	
	@PostMapping
	@Secured("ROLE_ADMIN")
	//String post(@RequestParam("photo") MultipartFile file, @RequestParam String firstname, @RequestParam String lastname, @RequestParam String[] positions, @RequestParam String country, @RequestParam @DateTimeFormat(pattern="yyyy-MM-dd") Date birthday, @RequestParam String biography, Model model) {
	String post(@Valid PersonalityDTO personality, Model model, Errors errors, RedirectAttributes redir) {
		if (!errors.hasErrors() && personalityService.add(personality)) {
			//model.addAttribute("result", "success");
			redir.addFlashAttribute("result", "success");
		} else {
			//model.addAttribute("result", "fail");
			redir.addFlashAttribute("result", "fail");
		}
		return "redirect:/admin/add/person";
	}
}
