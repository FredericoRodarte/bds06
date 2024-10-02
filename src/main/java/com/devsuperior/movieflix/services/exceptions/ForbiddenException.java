package com.devsuperior.movieflix.services.exceptions;

   /* Classe utilizada para retornar o erro 403. Retorna quando um usuário 
      logado não possui acesso a um determinado recurso.*/
public class ForbiddenException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ForbiddenException(String msg) {
		super(msg);
	}
}
