package classes.ufrpe.cine_easyplex.Exceptions;

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
