package br.com.ufrpe.cine_easyplex.interfaces;

import java.util.ArrayList;

import br.com.ufrpe.cine_easyplex.negocio.beans.Venda;
import br.com.ufrpe.cine_easyplex.utils.exceptions.PosicaoOcupadaException;
import br.com.ufrpe.cine_easyplex.utils.exceptions.ValorInvalidoException;

public interface iRepositorioVendas {
	
	public abstract boolean inserir(Venda venda) throws ValorInvalidoException, PosicaoOcupadaException;
	public abstract boolean remover(int idVenda) throws ValorInvalidoException;
	public abstract Venda pesquisar(int idVenda);
	public abstract ArrayList<Venda> listar();
	
}
