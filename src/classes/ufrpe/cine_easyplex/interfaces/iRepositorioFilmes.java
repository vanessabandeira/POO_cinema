package classes.ufrpe.cine_easyplex.interfaces;

import java.util.ArrayList;

import classes.ufrpe.cine_easyplex.beans.Filme;

public interface iRepositorioFilmes {
	
	public abstract boolean inserir(Filme filme);
	public abstract boolean remover(Filme filme);
	public abstract int pesquisar(Filme filme);
	public abstract ArrayList<Filme> listar();
	public abstract boolean alterar(Filme filme);
	

}
