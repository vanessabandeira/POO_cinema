package classes.ufrpe.cine_easyplex.dados;

public class PosicaoOcupadaException extends Exception {
	
	public String getMessage(){
		return "A posicao informada está ocupada";
	}
}
