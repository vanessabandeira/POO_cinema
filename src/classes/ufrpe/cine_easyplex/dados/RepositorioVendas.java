package classes.ufrpe.cine_easyplex.dados;

import java.util.ArrayList;
import classes.ufrpe.cine_easyplex.beans.Venda;

public class RepositorioVendas {
	private ArrayList<Venda> vendas;
	
	public RepositorioVendas(ArrayList<Venda> vendas){
		this.vendas = vendas;
	}
	
	public void inserir(Venda venda){
		this.vendas.add(venda);
	}
	public boolean remover(int idVenda){
		int indice = this.pesquisar(idVenda);
		if(indice != -1){
			this.vendas.remove(indice);
			return true;
		}
		return false;
	}
	public int pesquisar(int idVenda){
		for(int i = 0; i < this.vendas.size(); i++){
			if(this.vendas.get(i).getIdVenda()==idVenda){
				return this.vendas.indexOf(i);
			}
		}
		return -1;
	}
	public boolean alterar(Venda venda) {
		int indice = this.pesquisar(venda.getIdVenda());
		if(indice!=-1){
			this.vendas.set(indice, venda);
			return true;
		}
		return false;
		
	}
	
}
