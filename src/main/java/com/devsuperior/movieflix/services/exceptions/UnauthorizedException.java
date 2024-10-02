package com.devsuperior.movieflix.services.exceptions;

/* Classe utilizada para retornar o erro 401. Acesso não 
 * autorizado no login.*/
public class UnauthorizedException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public UnauthorizedException(String msg) {
		super(msg);
	}
}
