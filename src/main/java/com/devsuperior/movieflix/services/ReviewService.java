package com.devsuperior.movieflix.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.movieflix.dto.ReviewDTO;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.entities.Review;
import com.devsuperior.movieflix.repositories.MovieRepository;
import com.devsuperior.movieflix.repositories.ReviewRepository;

@Service
public class ReviewService {

	@Autowired
	private ReviewRepository repository;

	@Autowired
	private MovieRepository movieRepository;

	@Autowired
	private UserService userService;
	
    @Transactional(readOnly = true)
    public List<ReviewDTO> movieReviewByIdMovie(Long movieId) {
        List<Review> list = repository.findByMovieId(movieId);
        
        // Converte entidades para DTOs
        return list.stream()
                   .map(review -> new ReviewDTO(review, movieId))
                   .collect(Collectors.toList());
    }   

  

	@Transactional
	public ReviewDTO insert(ReviewDTO dto) {
	    Review entity = new Review();
	    entity.setText(dto.getText());

	    Movie movie = movieRepository.findById(dto.getMovieId()).get();
	    entity.setMovie(movie);

	    entity.setUser(userService.findProfileEntity());

	    entity = repository.save(entity);
	    return new ReviewDTO(entity);
	}
}
