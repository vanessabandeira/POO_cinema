package classes.ufrpe.cine_easyplex.interfaces;

import java.util.ArrayList;

import classes.ufrpe.cine_easyplex.Exceptions.ValorInvalidoException;
import classes.ufrpe.cine_easyplex.beans.Conta;
import classes.ufrpe.cine_easyplex.dados.RepositorioConta;

public interface iRepositorioContas {
	
	public ArrayList<Conta> getContas();

	public boolean inserir(Conta conta) throws ValorInvalidoException;

	public boolean remover(Conta conta) throws ValorInvalidoException;

	public int pesquisar(Conta conta);
}
