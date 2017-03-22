package br.com.ufrpe.cine_easyplex.utils.exceptions;

public class LoginException extends Exception{
	
	public String getMessage(){
		return "O login ou a senha são inválidos";
	}
}
