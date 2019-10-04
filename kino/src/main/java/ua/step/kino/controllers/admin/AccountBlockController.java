package ua.step.kino.controllers.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.step.kino.entities.Film;
import ua.step.kino.entities.Personality;
import ua.step.kino.entities.User;
import ua.step.kino.repositories.UsersRepository;

@Controller
@RequestMapping("/")
public class AccountBlockController {
	@Autowired
	UsersRepository usersRepository;

	@GetMapping("/admin/accountstatus/{id}")
	public String BlockAccount(@PathVariable("id") int id, Model model) {
		User user=usersRepository.getOne(id);
		user.setEnabled(!user.isEnabled());
		usersRepository.save(user);
		return "redirect:/users";
	}
}
