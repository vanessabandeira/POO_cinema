package classes.ufrpe.cine_easyplex.interfaces;

import java.util.ArrayList;

import classes.ufrpe.cine_easyplex.beans.Venda;

public interface iRepositorioVendas {
	
	public abstract boolean inserir(Venda venda);
	public abstract boolean remover(int idVenda);
	public abstract Venda pesquisar(int idVenda);
	public abstract ArrayList<Venda> listar();
	
}
