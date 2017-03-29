package br.com.ufrpe.cine_easyplex.utils.exceptions;

public class FilmeExistenteException extends Exception {
	public String getMessage() {
		return "O filme já está cadastrado.";
	}
}
