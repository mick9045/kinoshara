package ua.step.kino.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.step.kino.entities.Director;
import ua.step.kino.repositories.DirectorRepository;

/**
 * 
 * @author Azavoruyev
 *
 */
@Controller
@RequestMapping("/directors")
public class DirectorController {
	@Autowired DirectorRepository directorRepository;
	
	@GetMapping
	public String showAll(Model model) {
		List<Director> directors = directorRepository.findAll();
		model.addAttribute("directors", directors);
		return "directors";
	}
	
	
}