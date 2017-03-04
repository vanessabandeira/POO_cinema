package classes.ufrpe.cine_easyplex.dados;

import java.util.ArrayList;

import classes.ufrpe.cine_easyplex.beans.Filme;
import classes.ufrpe.cine_easyplex.beans.Venda;

public class RepositorioVendas {
	private ArrayList<Venda> vendas;
	
	public RepositorioVendas(ArrayList<Venda> vendas){
		this.vendas = vendas;
	}
	
	public boolean inserir(Venda venda){
		if(venda.getQtdIngressos() != 0){
			if(venda.getIndiceLugar().size()==venda.getQtdIngressos()){
				if(venda.getQtdMeias()<=venda.getQtdIngressos()){
					int conferir = 0;
					for(int i = 0; i < venda.getIndiceLugar().size(); i++){
						if(venda.getSessao().conferirOcupacao(venda.getIndiceLugar().get(i))){
							conferir++;
						}
					}
					if(conferir == venda.getIndiceLugar().size()){
						venda.setIdVenda(this.vendas.size()+1);
						for(int i = 0; i < venda.getIndiceLugar().size(); i++){
							venda.getSessao().getPosicao()[venda.getIndiceLugar().get(i)] = false;
						}
						this.vendas.add(venda);
						return true;
					}
				}
			}	
		}
		return false;
		
	}
	public boolean remover(int idVenda){
		Venda venda = this.pesquisar(idVenda);
		if(venda != null){
			for(int i = 0; i < venda.getIndiceLugar().size(); i++){
				if(venda.getSessao().getPosicao()[venda.getIndiceLugar().get(i)]){
					this.vendas.remove(venda);
					return true;
				}
			}
		}
		return false;
	}
	
	public Venda pesquisar(int idVenda) {
		for(int i = 0; i < this.vendas.size(); i++){
			if(idVenda == this.vendas.get(i).getIdVenda()){
				return this.vendas.get(i);
			}
		}
		return null;
	}
	
	
	
}
