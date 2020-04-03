package ua.step.kino.controllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ua.step.kino.entities.Film;
import ua.step.kino.repositories.FilmRepository;
import ua.step.kino.services.FilmFilterService;
import ua.step.kino.services.FilmPaginationService;
import ua.step.kino.services.FilmSearchService;
import ua.step.kino.services.FilmSortService;

/**
 * 
 * @author Kojevin
 *
 */

@Controller
@RequestMapping("/")
public class MoviesController {

	@Autowired
	FilmPaginationService filmPagi;
	
	@Autowired 
	FilmRepository filmsRepository;

	@Autowired(required = false)
	FilmSearchService searchService;
	
	@Autowired(required = false)
	FilmSortService sortService;

	@Autowired(required = false)
	FilmFilterService filterService;


	
	@GetMapping
	public String showAll(Model model, 
			 @RequestParam("page") Optional<Integer> page, 
		      @RequestParam("size") Optional<Integer> size/*,@PageableDefault(sort = { "id" }, direction = Direction.DESC) Pageable pageable*/) {
		
		int currentPage = page.orElse(1);
       int pageSize = size.orElse(6);
       
       Page<Film> films2 = filmPagi.findPaginated(PageRequest.of(currentPage - 1, pageSize));
       
       films2.forEach(f -> System.out.println(f.getTitle()));
       
		List<Film> films = filmsRepository.findAll();
		model.addAttribute("films", films2);
		
		int totalPages = films2.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                .boxed()
                .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
		
		return "allMovies";
	}
	
	@GetMapping(value = "search/{query}", produces = "application/json")
	@ResponseBody
	public String searchFilms(@PathVariable String query) {
		query = query.toLowerCase();
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.writeValueAsString(searchService.searchFilmsByName(query));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return "";
		}
	}
	
	@GetMapping(value = "searchresult/{query}", produces = "application/json")
	public String searchFilms2(@PathVariable String query, Model model) {
		ObjectMapper mapper = new ObjectMapper();
		
		model.addAttribute("films", searchService.searchFilmsByName(query));
		return "allMovies";
			
		
	}
	
	@GetMapping(value = "sort/{query}")
	public String sortFilms(@PathVariable String query, Model model) {
		List<Film> films = sortService.sortFilms(query);
		model.addAttribute("films", films);
		return "allMovies";
	}
	
	@GetMapping(value = {"filter/{type}","filter/{type}/{query}"})
	public String filterFilms(@PathVariable String type, @PathVariable(required = false) String query, Model model) {
		
		if(query == null)
		{
			 return "redirect:/";
		}
		
		List<Film> films = filterService.filterBy(type, query);
		model.addAttribute("films", films);
		return "allMovies";
	}
	

}
