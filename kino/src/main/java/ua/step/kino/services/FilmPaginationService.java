package ua.step.kino.services;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ua.step.kino.entities.Film;
import ua.step.kino.repositories.FilmRepository;

@Service
public class FilmPaginationService 
{

	@Autowired
	FilmRepository filmRepo;
	 
    public Page<Film> findPaginated(Pageable pageable) {
    	
    	List<Film> books = filmRepo.findAll();
    	
        int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage * pageSize;
        
        List<Film> list;
 
        if (books.size() < startItem) {
            list = Collections.emptyList();
        } else {
            int toIndex = Math.min(startItem + pageSize, books.size());
            list = books.subList(startItem, toIndex);
        }
 
        Page<Film> bookPage
          = new PageImpl<Film>(list, PageRequest.of(currentPage, pageSize), books.size());
 
        bookPage.forEach(f -> System.out.println(f.getTitle()));
        return bookPage;
    }
}
