package classes.ufrpe.cine_easyplex.interfaces;

import java.util.ArrayList;

import classes.ufrpe.cine_easyplex.beans.Sessao;

public interface iRepositorioSessao {

	public abstract boolean inserir(Sessao sessao);
	public abstract boolean remover(Sessao sessao);
	public abstract int pesquisar(Sessao sessao);
	public abstract ArrayList<Sessao> listar();
	public abstract boolean alterar(Sessao sessao);
}
