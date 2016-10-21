package classes.ufrpe.cine_easyplex.dados;

import classes.ufrpe.cine_easyplex.beans.Ingresso;
import classes.ufrpe.cine_easyplex.beans.Sessao;

public class RepositorioIngressos {
	private Ingresso[] ingressos;
	private int nIngressos;
	
	public RepositorioIngressos(int tamanho, int nIngressos) {
		this.ingressos = new Ingresso[tamanho];
		this.nIngressos = nIngressos;
	}
	
	public Ingresso pesquisarIngressoLugar(int IndiceLugar){
		for(int i=0;i<=nIngressos;i++){
			if(this.ingressos[i].indiceLugar==IndiceLugar){
				return this.ingressos[i];
			}
		}
		return null;
	}
	public Ingresso listarTudo(){
		//a implementar;
	}
	
	public Ingresso[] listarPorSessao(){
		//a implementar;
	}
	
	public boolean inserirIngresso(Ingresso inserido){
		if(this.pesquisarIngressoLugar(inserido.indiceLugar)==null){
			return false;
		}
		else{
			this.ingressos[nIngressos] = inserido;
			nIngressos++;
			return true;
		}
	}
	
}
