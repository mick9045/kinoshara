package ua.step.kino.services;

import org.springframework.beans.factory.annotation.Autowired;

import ua.step.kino.entities.Comment;
import ua.step.kino.repositories.CommentRepository;

public class CommentServiceImpl implements CommentService{

	@Autowired
	private CommentRepository commentRepository;

	@Override
	public Comment Add(Comment comment) {
		Comment createComment = comment;
		
		return commentRepository.saveAndFlush(createComment);
	}
	
}
