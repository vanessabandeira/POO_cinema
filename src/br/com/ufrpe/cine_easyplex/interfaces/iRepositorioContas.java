package br.com.ufrpe.cine_easyplex.interfaces;

import java.util.ArrayList;

import br.com.ufrpe.cine_easyplex.dados.RepositorioConta;
import br.com.ufrpe.cine_easyplex.negocio.beans.Conta;
import br.com.ufrpe.cine_easyplex.utils.exceptions.ValorInvalidoException;

public interface iRepositorioContas {
	
	public ArrayList<Conta> getContas();

	public boolean inserir(Conta conta) throws ValorInvalidoException;

	public boolean remover(Conta conta) throws ValorInvalidoException;

	public int pesquisar(Conta conta);
}
