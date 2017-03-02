package classes.ufrpe.cine_easyplex.beans;

import java.util.Date;

public class Sessao {
	private Date horario; //inicio da sessao
	public Filme exibicao;
	private Sala hall;
	private int ocupacao;
	private float valor; // valor do ingresso inteiro
	private int nvInteiro; // n�mero de vendas de ingressos inteiros
	private int nvMeia; // n�mero de vendas de meio ingressos
	private boolean[] posicao; // as cadeiras da sala

	/*
	 * public Sessao{ M�TODO CONSTRUTOR }
	 */
	public Sessao(Date horario, Filme exibicao, Sala hall) {
		this.exibicao = exibicao;
		this.horario = horario;
		this.hall = hall;
		this.posicao = new boolean[hall.getCapacidade()];
		this.nvInteiro = 0;
		this.nvMeia = 0;
		for (int i = 0; i < hall.getCapacidade(); i++) {
			this.posicao[i] = true;
		}
	}

	public void ocuparcadeira(int Poltrona) {
		this.posicao[Poltrona] = false;
	}

	public String getHorario() {
		return this.horario.toString();
	}

	public void setHorario(Date horario) {
		this.horario = horario;
	}

	public Filme getExibicao() {
		return exibicao;
	}

	public void setExibicao(Filme exibicao) {
		this.exibicao = exibicao;
	}

	public Sala getHall() {
		return hall;
	}

	public void setHall(Sala hall) {
		this.hall = hall;
	}

	public int getOcupacao() {
		return ocupacao;
	}

	public void setOcupacao(int ocupacao) {
		this.ocupacao = ocupacao;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public int getNvInteiro() {
		return nvInteiro;
	}

	public void setNvInteiro(int nvInteiro) {
		this.nvInteiro = nvInteiro;
	}

	public int getNvMeia() {
		return nvMeia;
	}

	public void setNvMeia(int nvMeia) {
		this.nvMeia = nvMeia;
	}

	public boolean[] getPosicao() {
		return posicao;
	}

	public void setPosicao(boolean[] posicao) {
		this.posicao = posicao;
	}

	public boolean equals(Sessao comparada) {
		if (this.exibicao.equals(comparada.exibicao)) {
			if (this.horario.equals(comparada.horario)) {
				if (this.hall.equals(comparada.hall)) {
					return true;
				}
			}
		}
		return false;
	}

}
