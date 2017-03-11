package classes.ufrpe.cine_easyplex.negocio;

import classes.ufrpe.cine_easyplex.beans.Conta;
import classes.ufrpe.cine_easyplex.dados.RepositorioConta;
import classes.ufrpe.cine_easyplex.interfaces.iRepositorioContas;

public class CadastroContas {
	iRepositorioContas repositorioContas;
	
	public CadastroContas()
	{
		this.repositorioContas = RepositorioConta.getInstance();
	}
	
	public boolean logar(String login, String senha){
		Conta conta = new Conta(login, senha);
		for(int i = 0; i < this.repositorioContas.getContas().size(); i++){
			if(this.repositorioContas.getContas().get(i).equals(conta)){
				return true;
			}
		}
		return false;
		
	}

}
