package classes.ufrpe.cine_easyplex.interfaces;

import java.util.ArrayList;

import classes.ufrpe.cine_easyplex.Exceptions.ValorInvalidoException;
import classes.ufrpe.cine_easyplex.beans.Venda;
import classes.ufrpe.cine_easyplex.Exceptions.PosicaoOcupadaException;

public interface iRepositorioVendas {
	
	public abstract boolean inserir(Venda venda) throws ValorInvalidoException, PosicaoOcupadaException;
	public abstract boolean remover(int idVenda) throws ValorInvalidoException;
	public abstract Venda pesquisar(int idVenda);
	public abstract ArrayList<Venda> listar();
	
}
