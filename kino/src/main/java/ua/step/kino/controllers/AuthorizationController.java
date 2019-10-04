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
import ua.step.kino.entities.VerificationToken;
import ua.step.kino.repositories.UsersRepository;
import ua.step.kino.services.FilmSortService;
import ua.step.kino.services.RegistrationService;
import ua.step.kino.services.UserService;
import ua.step.kino.verification.OnRegistrationCompleteEvent;
import validation.EmailExistsException;
import validation.LoginExistsException;
import validation.UserDto;

import java.util.Calendar;
import java.util.Date;


import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.ApplicationEventPublisher;

/**
 * 
 * @author Kojevin
 *
 */

@Controller
@RequestMapping("/login")
public class AuthorizationController {
	
	@Autowired 
	UsersRepository usersRepository;

	@Autowired(required = false)
	RegistrationService registrationService;
	
	@Autowired
	ApplicationEventPublisher eventPublisher;

	Integer count=0;
	
	@GetMapping
	public String showAll(Model model, @RequestParam Optional<String> error, @RequestParam Optional<String> logout, @RequestParam Optional<String> pass) 
	{
		if (error.isPresent()) {
			model.addAttribute("error", "Invalid login or password.");
			count++;
		} else if (logout.isPresent()) {
			model.addAttribute("logout", "You have successfully log out.");
		}
		if(count>2) {model.addAttribute("pass", "Forgot your password?");
		model.addAttribute("error", "If you are sure in input data your account might be blocked. Please contact to the administrator for information");}
		return "login"; 
	}
	
	@GetMapping(value="/registration")
	public String showAll1(Model model) 
	{
		List<User> users = usersRepository.findAll();
		model.addAttribute("users", users);
		return "registration";
	}
	
	@PostMapping(value = "/registration")
	public String registerUserAccount(
			Model model,
	  @ModelAttribute("user") @Valid UserDto accountDto, 
	  BindingResult result, 
	  WebRequest request, 
	  Errors errors) {
	     
		User registered = null;
		
	    if (!result.hasErrors()) {
	    	try {
	    		registered = createUserAccount(accountDto, result);
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

		try {
			eventPublisher.publishEvent(new OnRegistrationCompleteEvent(registered));
			model.addAttribute("error", "Please verify your email address."
					+ "An email containing verification instructions was sent to " + registered.getEmail());
		} catch (Exception me) {
			model.addAttribute("error", "Error sending of the email");
			return "registration";
		}
		
			return "registration";
	    }
	
	private User createUserAccount(@Valid UserDto accountDto, BindingResult result) throws EmailExistsException, LoginExistsException {
	    User registered = null;
	  
	        registered = registrationService.registerNewUserAccount(accountDto);
	  
	    return registered;
	}
	
	@GetMapping(value = "/registrationConfirm")
	public String confirmRegistration
	  (WebRequest request, Model model, @RequestParam("token") String token) {
	    VerificationToken verificationToken = registrationService.getVerificationToken(token);
	    if (verificationToken == null) {
	        model.addAttribute("error", "Invalid token");
			return "registration";
	    }
	     
	    User user = verificationToken.getUser();
	    Calendar cal = Calendar.getInstance();
	    if ((verificationToken.getExpiryDate().getTime() - cal.getTime().getTime()) <= 0) {
	        model.addAttribute("error", "Expired token");
			return "registration";
	    } 
	     
	    user.setEnabled(true); 
 	    registrationService.saveRegisteredUser(user); 

	    return "login"; 
	}
	
	 @InitBinder
	    public void initBinder(WebDataBinder binder) {
	        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	        dateFormat.setLenient(false);
	        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	    }

}
