package ua.step.kino.controllers.admin;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("admin/add/film")
public class AddFilmController {
	
	@GetMapping
	//@Secured("ROLE_ADMIN")
	String get()
	{
		return "admin/pages/add_film";
	}
}

