package br.com.ufrpe.cine_easyplex.utils.exceptions;

public class SenhasDiferentesException extends Exception{
	
	public String getMessage(){
		return "As senhas são diferentes";
	}
}
