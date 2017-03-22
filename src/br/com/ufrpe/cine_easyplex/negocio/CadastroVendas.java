package br.com.ufrpe.cine_easyplex.negocio;

import java.util.Date;

import br.com.ufrpe.cine_easyplex.dados.RepositorioVendas;
import br.com.ufrpe.cine_easyplex.interfaces.iRepositorioVendas;
import br.com.ufrpe.cine_easyplex.negocio.beans.Venda;
import br.com.ufrpe.cine_easyplex.utils.exceptions.PosicaoOcupadaException;
import br.com.ufrpe.cine_easyplex.utils.exceptions.ValorInvalidoException;

public class CadastroVendas {
	iRepositorioVendas repositorioVendas;
	
	public CadastroVendas()
	{
		this.repositorioVendas = RepositorioVendas.getInstance();
	}
	
	public void adicionarVenda(Venda venda) throws ValorInvalidoException, PosicaoOcupadaException{
		this.repositorioVendas.inserir(venda);
	}
	public void removerVenda(int idVenda) throws ValorInvalidoException{
		this.repositorioVendas.remover(idVenda);
	}
	
	public double arrecadacao(){
		double valorArrecadado = 0;
		for(int i = 0; i<this.repositorioVendas.listar().size(); i++){
			valorArrecadado+=this.repositorioVendas.listar().get(i).calcularPreco();
		}
		return valorArrecadado;
	}
	
	public iRepositorioVendas getRepositorioVendas() {
		return repositorioVendas;
	}

	public void setRepositorioVendas(iRepositorioVendas repositorioVendas) {
		this.repositorioVendas = repositorioVendas;
	}
	
}
