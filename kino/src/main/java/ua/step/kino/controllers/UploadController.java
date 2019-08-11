package ua.step.kino.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import ua.step.kino.services.UploadService;

@Controller
@RequestMapping("/upload")
public class UploadController {

	@Autowired UploadService uploadService;
	
	@GetMapping
	//@Secured("ROLE_ADMIN")
	public String Test(){
		
		return "fileUploadTest";
	}
	
	@PostMapping()
	public String Test(@RequestParam("file") MultipartFile file, ModelMap modelMap) {
	   
		uploadService.uploadBigPoster(file);
		modelMap.addAttribute("response", uploadService.uploadSmallPoster(file));
	    return "fileUploadResult";
	}
}



