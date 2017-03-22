package classes.ufrpe.cine_easyplex.Exceptions;

public class LoginException extends Exception{
	
	public String getMessage(){
		return "O login ou a senha são inválidos";
	}
}
