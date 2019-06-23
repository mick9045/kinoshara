package ua.step.kino.controllers;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ImageController {

	@GetMapping("image/{name}")
	  public void getImage(@PathVariable String name, HttpServletResponse httpServletResponse) {
	    String path = "http://kinoshara.kl.com.ua/img/";
	    httpServletResponse.setHeader("Location", path + name);
	    httpServletResponse.setStatus(302);
	  }
	
}
