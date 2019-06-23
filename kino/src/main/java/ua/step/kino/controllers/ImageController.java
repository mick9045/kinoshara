package ua.step.kino.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ImageController {

	@GetMapping("image/{name}")
	  public String getImage(@PathVariable String name) {
	    String path = "http://kinoshara.kl.com.ua/img/";
	    return "redirect:" + path + name;
	  }
	
	
	
}
