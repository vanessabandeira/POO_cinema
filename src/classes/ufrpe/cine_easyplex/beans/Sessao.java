package classes.ufrpe.cine_easyplex.beans;

import java.time.LocalDate;
import java.time.LocalTime;

public class Sessao {
	private LocalTime horario;
	public Filme exibicao;
	private LocalDate data; // SERÁ SUBSTITUIDO POR UM OBJETO DO TIPO LocalDate da
						// biblioteca Java.time
	private Sala hall;
	private int ocupacao;
	private float valor; // valor do ingresso inteiro
	private int nvInteiro; // número de vendas de ingressos inteiros
	private int nvMeia; // número de vendas de meio ingressos
	private boolean[] posicao; // as cadeiras da sala

	/*
	 * public Sessao{ MÉTODO CONSTRUTOR }
	 */
	public Sessao(LocalTime horario, Filme exibicao, LocalDate data, Sala hall){
		this.exibicao=exibicao;
		this.horario=horario;
		this.data=data;
		this.hall=hall;
		this.posicao = new boolean[hall.getCapacidade()];
		this.nvInteiro=0;
		this.nvMeia=0;
		for(int i; i<hall.getCapacidade(); i++){
			this.posicao[i]=true;
		}
	}
	public void ocuparcadeira(int Poltrona) {
		this.posicao[Poltrona] = false;
	}
	public LocalTime getHorario() {
		return horario;
	}
	public void setHorario(LocalTime horario) {
		this.horario = horario;
	}
	public Filme getExibicao() {
		return exibicao;
	}
	public void setExibição(Filme exibicao) {
		this.exibicao = exibicao;
	}
	public Sala getHall() {
		return hall;
	}
	public void setHall(Sala hall) {
		this.hall = hall;
	}
	public int getOcupação() {
		return ocupacao;
	}
	public void setOcupação(int ocupacao) {
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
	
}
