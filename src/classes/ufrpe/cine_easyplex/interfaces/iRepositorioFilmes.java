package classes.ufrpe.cine_easyplex.interfaces;

import java.util.ArrayList;

import classes.ufrpe.cine_easyplex.Exceptions.ValorInvalidoException;
import classes.ufrpe.cine_easyplex.beans.Filme;

public interface iRepositorioFilmes {
	
	public abstract boolean inserir(Filme filme) throws ValorInvalidoException;
	public abstract boolean remover(Filme filme) throws ValorInvalidoException;
	public abstract int pesquisar(Filme filme);
	public abstract ArrayList<Filme> listar();
	public abstract boolean alterar(Filme filme) throws ValorInvalidoException;
	
	
	

}
