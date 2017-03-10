package classes.ufrpe.cine_easyplex.negocio;

import classes.ufrpe.cine_easyplex.dados.RepositorioConta;

public class CadastroContas {
	RepositorioConta repositorioContas;
	
	public CadastroContas()
	{
		this.repositorioContas = RepositorioConta.getInstance();
	}
	
	public void adicionarConta(){
		//fiquei em duvida se vai ser necessario isso
		//discutir sobre isso e remoção tbm
	}
	public void removerConta(){
		
	}
	public boolean logar(){
		return true;
		
	}

}
