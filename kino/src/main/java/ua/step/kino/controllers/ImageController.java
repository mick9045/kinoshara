package ua.step.kino.controllers;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 
 * @author Kojevin
 *
 */
@Controller
public class ImageController {

	@GetMapping("image/{type}/{name}")
	  public void getImage(@PathVariable String type, @PathVariable String name, HttpServletResponse httpServletResponse) {
	    String path = "http://mick9045.000webhostapp.com/images/" + type +"/" + name;
	    httpServletResponse.setHeader("Location", path);
	    httpServletResponse.setStatus(302);
	  }
	
}
