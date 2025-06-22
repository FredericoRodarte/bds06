package com.devsuperior.movieflix.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.movieflix.dto.MovieDTO;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.repositories.GenreRepository;
import com.devsuperior.movieflix.repositories.MovieRepository;
import com.devsuperior.movieflix.services.exceptions.ResourceNotFoundException;

@Service
public class MovieService {

	@Autowired
	private MovieRepository repository;
	
	@Autowired
	private GenreRepository genereRepository;	
	
	@Transactional(readOnly = true)
	public MovieDTO findById(Long id) {
		
		Optional<Movie> obj = repository.findById(id);
		Movie entity = obj.orElseThrow(() -> new ResourceNotFoundException("*Entity not found*"));
		
		return new MovieDTO(entity,entity.getGenre());//entity.getCategories());
		
	}	
	
	@Transactional(readOnly = true)
	public Page<MovieDTO> findAllPaged(	Long     genereId  ,
										Pageable pageable){
		Page<Movie> page = repository.findMoviesByGenre(genereId,pageable);
		return page.map(x -> new MovieDTO(x,x.getGenre()));
		
	}	
	
    @Transactional(readOnly = true)
    public Page<MovieDTO> findByGenre(Long genreId, Pageable pageable) {
        Page<Movie> result;
       
        result = repository.findMoviesByGenre(genreId, pageable);

        // Converte entidades para DTOs
        return result.map(movie -> new MovieDTO(movie));
    }
	
}
