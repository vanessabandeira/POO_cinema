package br.com.ufrpe.cine_easyplex.utils.exceptions;

public class PosicaoOcupadaException extends Exception {
	
	public String getMessage(){
		return "A posicao informada está ocupada";
	}
}
