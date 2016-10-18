package classes;

public class RepositorioSessao {
	private Sessao[] sessoes; // serve para mostrar quais os filmes disponíveis
								// e em quais horários e salas
	private int nSessões;

	/*
	 * public RepositorioSessao{ MÉTODO CONSTRUTOR }
	 */

	public boolean inserir(Sessao sessao) {
		// A desenvolver
		// Insere uma Sessão no Array de sessões
		this.sessoes[nSessoes]=sessao;
	}

	public boolean remover(Sessão Sessão) {
		// A desenvolver
		// Remove uma sessão do array
		
	}

	public void pesquisarHorario(/* HoraInicio, HoraFim */) {
		// recebe horario de inicio e fim e imprime sessões disponíveis entre o
		// período,
		// caso horafim seja NULL, imprimirá todas as sessões disponíveis após o
		// horario de inicio
		// HoraInício não pode ser NULL
		
	}

	public Sessao pesquisarFilme(Filme filme){
		//retorna sessão que contenha o filme especificado
		if(filme==null){
			return null;
			//imprimir na tela o erro
		}
		for(int i=0; i<nSessoes; i++){
			if(this.sessoes[i].exibicao.equals(filme)){
				return this.sessoes[i];
			}
		}
	}

	public Sessao pesquisarSala(int identidade) {
		// retorna a sessão atual da sala pesquisada;
		for(int i=0; i<nSessoes; i++){
			if(this.sessoes[i].hall.identidade==identidade){
				return this.sessoes[i];
			}
		}
	}

	public boolean alterar(Sessao sessao) {
		// altera inforçoes de uma sessao, retornando verdadeiro caso ela
		// exista. Retorna falso, caso a sessão não exista
	}

	public void listar() {
		// Imprime todas as sessões disponiveis;
	}

}
