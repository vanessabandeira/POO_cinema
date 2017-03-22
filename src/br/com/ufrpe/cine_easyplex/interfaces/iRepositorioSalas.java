package br.com.ufrpe.cine_easyplex.interfaces;

import java.util.ArrayList;

import br.com.ufrpe.cine_easyplex.negocio.beans.Sala;
import br.com.ufrpe.cine_easyplex.utils.exceptions.ValorInvalidoException;

public interface iRepositorioSalas {
	
	public abstract boolean inserir(Sala sala) throws ValorInvalidoException;
	public abstract boolean remover(Sala sala);
	public abstract int pesquisar(Sala sala);
	public abstract ArrayList<Sala> listar();
	public abstract boolean alterar(Sala sala);

}
