package com.devsuperior.movieflix.dto;

import java.io.Serializable;

import com.devsuperior.movieflix.entities.Review;
import com.devsuperior.movieflix.entities.User;

public class ReviewDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	// TODO Auto-generated constructor stub
	
	private Long   id;
	private String text;
	private Long  movieId;
	private UserDTO   userDTO;
	
	
	public ReviewDTO() {
	}

	public ReviewDTO(Review review,Long movieId) {		
		id              = review.getId();
		text            = review.getText();
		userDTO         = new UserDTO (review.getUser() );
		this.movieId    = movieId;
	}
	
	public ReviewDTO(Review review) {		
		id              = review.getId();
		text            = review.getText();
		userDTO         = new UserDTO (review.getUser() );
		this.movieId    = review.getMovie().getId();
	}
	
	public Long getId() {
		return id;
	}

	public String getText() {
		return text;
	}

	public UserDTO getUserDTO() {
		return userDTO;
	}

	public Long getMovieId() {
		return movieId;
	}

	public void setUserDTO(UserDTO userDTO) {
		this.userDTO = userDTO;
	}
}
