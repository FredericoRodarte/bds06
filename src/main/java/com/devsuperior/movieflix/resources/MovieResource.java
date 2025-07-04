package com.devsuperior.movieflix.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.movieflix.dto.MovieDTO;
import com.devsuperior.movieflix.dto.MovieNoGenreDTO;
import com.devsuperior.movieflix.dto.ReviewDTO;
import com.devsuperior.movieflix.services.MovieService;
import com.devsuperior.movieflix.services.ReviewService;


@RestController
@RequestMapping(value = "/movies")
public class MovieResource {

	@Autowired
	private MovieService movieService;

	@Autowired
	private ReviewService reviewService;
	
	@GetMapping
    public ResponseEntity<Page<MovieNoGenreDTO>> findMoviesByGenre(
        @RequestParam(value = "genreId", defaultValue = "0") Long genreId,
        @PageableDefault(sort = "title") Pageable pageable
    ) {
        Page<MovieNoGenreDTO> page = movieService.findByGenre(genreId, pageable);
        //System.out.print("controle="+genreId);
        return ResponseEntity.ok(page);
    }

	@RequestMapping(value = "/{id}")		
	public ResponseEntity<MovieDTO> findById(@PathVariable Long id) {
		MovieDTO dto = movieService.findById(id);
		return ResponseEntity.ok().body(dto);
	}

	@GetMapping("/{id}/reviews")
	public ResponseEntity<List<ReviewDTO>> reviewsByIdMovie(@PathVariable Long id) {
	    List<ReviewDTO> list = reviewService.movieReviewByIdMovie(id);
	    return ResponseEntity.ok().body(list);
	}
}
