package classes.ufrpe.cine_easyplex.beans;

import java.util.ArrayList;

public class Venda {
	private ArrayList<Ingresso> ingressos;
	private int idVenda,valorInteiro;
	
	public Venda(ArrayList<Ingresso> ingressos){
		this.ingressos = new ArrayList<Ingresso>();
	}
	
	public float calcularPreço(){
		int meiaEntrada = 0;
		int quantidade = this.ingressos.size();
		for(int i = 0; i < quantidade; i++){
			if(this.ingressos.get(i).getMeia()){
				meiaEntrada++;
			}
		}
		return (quantidade-meiaEntrada)*valorInteiro + meiaEntrada*valorInteiro/2;
	}

	public ArrayList<Ingresso> getIngressos() {
		return ingressos;
	}

	public void setIngressos(ArrayList<Ingresso> ingressos) {
		this.ingressos = ingressos;
	}

	public int getIdVenda() {
		return idVenda;
	}

	public void setIdVenda(int idVenda) {
		this.idVenda = idVenda;
	}
}
