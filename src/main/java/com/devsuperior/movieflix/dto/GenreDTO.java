package com.devsuperior.movieflix.dto;

import java.util.Objects;

import com.devsuperior.movieflix.entities.Genre;

public class GenreDTO {
	private Long    id      ;
	private String  name    ;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GenreDTO other = (GenreDTO) obj;
		return Objects.equals(id, other.id);
	}

	
	@Override
	public String toString() {
		return "GenreDTO [id=" + id + ", name=" + name + "]";
	}
	
	
	public GenreDTO() {
	}

	public GenreDTO(Long id, String name) {
		this.id = id;
		this.name = name;
	}
	

	public GenreDTO(Genre g) {
		this.id = g.getId();
		this.name = g.getName();
	}
}
