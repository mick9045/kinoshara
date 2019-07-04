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

/**
 * 
 * @author Julia
 *
 */
@Controller
@RequestMapping("/comments")
public class CommentController {
	@Autowired CommentRepository commentRepository;
	
//	@GetMapping
//	public String showAll(Model model) {
//		List<Comment> comments = commentRepository.findAll();
//		model.addAttribute("comments", comments);
//		return "comments";
//	}
	
	@RequestMapping(value = "/addComment", method = RequestMethod.POST)
	private String addComment(@ModelAttribute("comments") Comment comment) {
		comment.setDate(new Date());
		commentRepository.save(comment);
		return "addComment";
	}
}
