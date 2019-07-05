package ua.step.kino.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.step.kino.entities.Comment;
import ua.step.kino.repositories.CommentRepository;
import ua.step.kino.repositories.FilmRepository;
import ua.step.kino.repositories.UsersRepository;

/**
 * 
 * @author Julia
 *
 */
@Controller
@RequestMapping("/comments")
public class CommentController {
	
	@Autowired
	private CommentRepository commentRepository;
	@Autowired
	private FilmRepository filmRepository;
	@Autowired
	private UsersRepository userRepository;
	
	@GetMapping
	public String showAll(Model model) {
		List<Comment> comment = commentRepository.findAll();
		model.addAttribute("coments", comment);
		return "comments";
	}
	
	@RequestMapping(value = "/addComment", method = RequestMethod.POST)
	private String addComment(Model model, Integer filmId, Integer userId, String text) {
		
		
		Comment comment = new Comment();
		comment.setFilm(filmRepository.findById(filmId).get());
		comment.setUser(userRepository.findById(userId).get());
		comment.setText(text);
		comment.setDate(new Date());
		
		commentRepository.save(comment);
		
		//System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!" + comment.getText() + comment.getUser()+ comment.getFilm() + comment.getDate());

		return "redirect:/films/" + comment.getFilm().getId();
	}
}
