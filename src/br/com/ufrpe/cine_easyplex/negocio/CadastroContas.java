package br.com.ufrpe.cine_easyplex.negocio;

import br.com.ufrpe.cine_easyplex.dados.RepositorioConta;
import br.com.ufrpe.cine_easyplex.interfaces.iRepositorioContas;
import br.com.ufrpe.cine_easyplex.negocio.beans.Conta;
import br.com.ufrpe.cine_easyplex.utils.exceptions.LoginException;
import br.com.ufrpe.cine_easyplex.utils.exceptions.ValorInvalidoException;

public class CadastroContas {
	iRepositorioContas repositorioContas;
	
	public CadastroContas()
	{
		this.repositorioContas = RepositorioConta.getInstance();
	}
	
	public boolean logar(String login, String senha) throws LoginException{
		Conta conta = new Conta(login, senha);
		for(int i = 0; i < this.repositorioContas.getContas().size(); i++){
			if(this.repositorioContas.getContas().get(i).equals(conta)){
				return true;
			}
		}
		throw new LoginException();
		
	}
	public void adicionarConta(Conta conta) throws ValorInvalidoException{
		this.repositorioContas.inserir(conta);
	}
	
	public void removerConta(Conta conta) throws ValorInvalidoException{
		this.repositorioContas.remover(conta);
	}

}
