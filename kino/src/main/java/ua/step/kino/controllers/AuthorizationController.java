package ua.step.kino.controllers;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import ua.step.kino.entities.User;
import ua.step.kino.repositories.UsersRepository;
import ua.step.kino.services.FilmSortService;
import ua.step.kino.services.RegistrationService;
import ua.step.kino.validation.EmailExistsException;
import ua.step.kino.validation.LoginExistsException;
import ua.step.kino.validation.UserDto;

import java.util.Date;


import org.springframework.beans.propertyeditors.CustomDateEditor;

/**
 * 
 * @author Kojevin
 *
 */

@Controller
@RequestMapping("/login")
public class AuthorizationController {
	
@Autowired UsersRepository usersRepository;

	@Autowired(required = false)
	RegistrationService registrationService;

	@GetMapping
	public String showAll(Model model, @RequestParam Optional<String> error, @RequestParam Optional<String> logout) 
	{
		if (error.isPresent()) {
			model.addAttribute("error", "Invalid login or password.");
		} else if (logout.isPresent()) {
			model.addAttribute("logout", "You have successfully log out.");
		}
		return "login"; 
	}
	
	@GetMapping(value="/registration")
	public String showAll1(Model model) 
	{
		
		return "registration";
	}
	
	@PostMapping(value = "/registration")
	public String registerUserAccount(
			Model model,
	  @ModelAttribute("user") @Valid UserDto accountDto, 
	  BindingResult result, 
	  WebRequest request, 
	  Errors errors) {
	     
	
	    if (!result.hasErrors()) {
	    	try {
	       createUserAccount(accountDto, result);
	        }
	    	catch(EmailExistsException e) {
	    	
	    	
	    		model.addAttribute("error", "Email already exists");
	    		return "registration";
	    	}
	    	catch(LoginExistsException e) {
		    	
	    		
	    		model.addAttribute("error", "User already exists");
	    		return "registration";
	    	}
	    }
	   
	        return "redirect:/";
	    }
	
	private User createUserAccount(@Valid UserDto accountDto, BindingResult result) throws EmailExistsException, LoginExistsException {
	    User registered = null;
	  
	        registered = registrationService.registerNewUserAccount(accountDto);
	  
	    return registered;
	}
	
	 @InitBinder
	    public void initBinder(WebDataBinder binder) {
	        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	        dateFormat.setLenient(false);
	        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	    }

}
