package br.com.ufrpe.cine_easyplex.negocio.beans;

import java.io.Serializable;
import java.util.ArrayList;

public class Venda implements Serializable {
	private boolean meia;;
	private Sessao sessao;
	private int indiceLugar; 
	private float valorInteiro;
	private int idVenda;
	
	public Venda(int qtdIngressos, int qtdMeias, Sessao sessao, int indiceLugar, int valorInteiro) {
		super();
		this.meia = meia;;
		this.sessao = sessao;
		this.indiceLugar = indiceLugar;
		this.valorInteiro = valorInteiro;
	}
	
	public Venda(){
		
	}

	public float calcularPreco(){
		if(meia) return this.valorInteiro/2;
		else return this.valorInteiro;
	}

	public Sessao getSessao() {
		return sessao;
	}

	public void setSessao(Sessao sessao) {
		this.sessao = sessao;
	}


	public boolean isMeia() {
		return meia;
	}

	public void setMeia(boolean meia) {
		this.meia = meia;
	}

	public int getIndiceLugar() {
		return indiceLugar;
	}

	public void setIndiceLugar(int indiceLugar) {
		this.indiceLugar = indiceLugar;
	}

	public float getValorInteiro() {
		return valorInteiro;
	}

	public void setValorInteiro(float valorInteiro) {
		this.valorInteiro = valorInteiro;
	}

	public int getIdVenda() {
		return idVenda;
	}

	public void setIdVenda(int idVenda) {
		this.idVenda = idVenda;
	}


	
}
