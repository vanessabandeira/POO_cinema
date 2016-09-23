package classes;

public class Sessao {
	private int[] Horario;
	public Filme Exibição;
	private int[] Data; //SERÁ SUBSTITUIDO POR UM OBJETO DO TIPO LocalDate da biblioteca Java.time
	private Sala Hall;
	private int ocupação;
	private float valor; // valor do ingresso inteiro
	private int nvInteiro; // número de vendas de ingressos inteiros
	private int nvMeia; // número de vendas de meio ingressos
	private boolean[] posição; // as cadeiras da sala

	/*
	 * public Sessao{
	 *  MÉTODO CONSTRUTOR
	 * }
	 */
	public void ocuparcadeira(int Poltrona) {
		this.posição[Poltrona] = false;
	}
}
