package classes.ufrpe.cine_easyplex.beans;

import java.util.ArrayList;

public class Venda {
	private int qtdIngressos, qtdMeias;
	private Sessao sessao;
	private ArrayList<Integer> indiceLugar; 
	private int valorInteiro;
	private int idVenda;
	
	public Venda(int qtdIngressos, int qtdMeias, Sessao sessao, ArrayList<Integer> indiceLugar, int valorInteiro) {
		super();
		this.qtdIngressos = qtdIngressos;
		this.qtdMeias = qtdMeias;
		this.sessao = sessao;
		this.indiceLugar = indiceLugar;
		this.valorInteiro = valorInteiro;
	}

	public float calcularPreço(){
		return (this.qtdIngressos-this.qtdMeias)*valorInteiro + this.qtdMeias*valorInteiro/2;
	}

	public int getQtdIngressos() {
		return qtdIngressos;
	}

	public void setQtdIngressos(int qtdIngressos) {
		this.qtdIngressos = qtdIngressos;
	}

	public int getQtdMeias() {
		return this.getQtdMeias();
	}

	public void setQtdMeias(int qtdMeias) {
		this.qtdMeias = qtdMeias;
	}

	public Sessao getSessao() {
		return sessao;
	}

	public void setSessao(Sessao sessao) {
		this.sessao = sessao;
	}

	public ArrayList<Integer> getIndiceLugar() {
		return indiceLugar;
	}

	public void setIndiceLugar(ArrayList<Integer> indiceLugar) {
		this.indiceLugar = indiceLugar;
	}

	public int getValorInteiro() {
		return valorInteiro;
	}

	public void setValorInteiro(int valorInteiro) {
		this.valorInteiro = valorInteiro;
	}

	public int getIdVenda() {
		return idVenda;
	}

	public void setIdVenda(int idVenda) {
		this.idVenda = idVenda;
	}


	
}
