package classes.ufrpe.cine_easyplex.Exceptions;

public class SenhasDiferentesException extends Exception{
	
	public String getMessage(){
		return "As senhas são diferentes";
	}
}
