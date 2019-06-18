package ua.step.kino.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import ua.step.kino.repositories.DirectorRepository;

/**
 * 
 * @author Azavoruyev
 *
 */
@Controller
public class DirectorController {
	@Autowired
	private DirectorRepository directorRepository;

}
