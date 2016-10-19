package classes.ufrpe.cine_easyplex.beans;

public class Sessao {
	private LocalTime horario;
	public Filme exibição;
	private LocalDate; // SERÁ SUBSTITUIDO POR UM OBJETO DO TIPO LocalDate da
						// biblioteca Java.time
	private Sala hall;
	private int ocupação;
	private float valor; // valor do ingresso inteiro
	private int nvInteiro; // número de vendas de ingressos inteiros
	private int nvMeia; // número de vendas de meio ingressos
	private boolean[] posicao; // as cadeiras da sala

	/*
	 * public Sessao{ MÉTODO CONSTRUTOR }
	 */
	public class Sessao(LocalTime horario, Filme exibicao, LocalDate data, Sala hall){
		this.exibicao=exibicao;
		this.horario=horario;
		this.data=data;
		this.hall=hall;
		this.posicao = new boolean[hall.capacidade];
		this.nvInteiro=0;
		this.nvMeia=0;
		for(int i; i<hall.capacidade; i++){
			this.posicao[i]=true;
		}
	}
	public void ocuparcadeira(int Poltrona) {
		this.posição[Poltrona] = false;
	}
}
