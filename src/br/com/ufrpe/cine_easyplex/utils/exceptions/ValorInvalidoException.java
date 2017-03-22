package br.com.ufrpe.cine_easyplex.utils.exceptions;

@SuppressWarnings("serial")
public class ValorInvalidoException extends Exception{
	
	private String valor;
	
	public ValorInvalidoException(String valor) {
		super();
		this.valor = valor;
	}

	public String getMessage(){
		return "O valor de " + this.valor + " é inválido";
	}

}
