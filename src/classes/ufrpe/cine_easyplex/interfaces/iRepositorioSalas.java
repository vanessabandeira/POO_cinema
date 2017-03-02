package classes.ufrpe.cine_easyplex.interfaces;

import java.util.ArrayList;

import classes.ufrpe.cine_easyplex.beans.Sala;

public interface iRepositorioSalas {
	
	public abstract boolean inserir(Sala sala);
	public abstract boolean remover(Sala sala);
	public abstract int pesquisar(Sala sala);
	public abstract ArrayList<Sala> listar();
	public abstract boolean alterar(Sala sala);

}
