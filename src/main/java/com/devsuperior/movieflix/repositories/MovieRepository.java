package com.devsuperior.movieflix.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.entities.Review;

public interface MovieRepository extends JpaRepository<Movie, Long>{
	
	@Query(
            value = "SELECT * FROM tb_movie WHERE (:genreId = 0 OR genre_id = :genreId)",
            nativeQuery = true
        )
        Page<Movie> findMoviesByGenre(@Param("genreId") Long genreId, Pageable pageable);
	
}
