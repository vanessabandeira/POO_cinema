package classes.ufrpe.cine_easyplex.Exceptions;

public class PosicaoOcupadaException extends Exception {
	
	public String getMessage(){
		return "A posicao informada está ocupada";
	}
}
