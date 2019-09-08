package ua.step.kino.controllers.admin;

import javax.validation.Valid;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ua.step.kino.dto.FilmDTO;

@Controller
@RequestMapping("admin/controlPanel")
public class ControlPanelController {
	
	@GetMapping
	@Secured("ROLE_ADMIN")
	String get(Model model) {
		
		return "admin/control_panel";
	}
	
	@PostMapping
	@Secured("ROLE_ADMIN")
	String post(Model model) {
	
		return "redirect:/admin/controlPanel";
	}
}

