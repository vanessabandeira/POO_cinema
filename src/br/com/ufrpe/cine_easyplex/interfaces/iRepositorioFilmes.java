package br.com.ufrpe.cine_easyplex.interfaces;

import java.util.ArrayList;

import br.com.ufrpe.cine_easyplex.negocio.beans.Filme;
import br.com.ufrpe.cine_easyplex.utils.exceptions.ValorInvalidoException;

public interface iRepositorioFilmes {
	
	public abstract boolean inserir(Filme filme) throws ValorInvalidoException;
	public abstract boolean remover(Filme filme) throws ValorInvalidoException;
	public abstract int pesquisar(Filme filme);
	public abstract ArrayList<Filme> listar();
	public abstract boolean alterar(Filme filme) throws ValorInvalidoException;
	public abstract void salvarArquivo();
	
	
	

}
