package classes.ufrpe.cine_easyplex.dados;

import classes.ufrpe.cine_easyplex.beans.Filme;
import classes.ufrpe.cine_easyplex.beans.Sessao;

public class RepositorioSessao {
	private Sessao[] sessoes; // serve para mostrar quais os filmes dispon�veis
								// e em quais hor�rios e salas
	private int nSessoes;

	/*
	 * public RepositorioSessao{ M�TODO CONSTRUTOR }
	 */

	public boolean inserir(Sessao sessao) {
		// A desenvolver
		// Insere uma Sess�o no Array de sess�es
		this.sessoes[nSessoes]=sessao;
	}

	public boolean remover(Sessao Sessao) {
		// A desenvolver
		// Remove uma sess�o do array
		
	}

	public void pesquisarHorario(/* HoraInicio, HoraFim */) {
		// recebe horario de inicio e fim e imprime sess�es dispon�veis entre o
		// per�odo,
		// caso horafim seja NULL, imprimir� todas as sess�es dispon�veis ap�s o
		// horario de inicio
		// HoraIn�cio n�o pode ser NULL
		
	}

	public Sessao pesquisarFilme(Filme filme){
		//retorna sess�o que contenha o filme especificado
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
		// retorna a sess�o atual da sala pesquisada;
		for(int i=0; i<nSessoes; i++){
			if(this.sessoes[i].hall.identidade==identidade){
				return this.sessoes[i];
			}
		}
	}

	public boolean alterar(Sessao sessao) {
		// altera infor�oes de uma sessao, retornando verdadeiro caso ela
		// exista. Retorna falso, caso a sess�o n�o exista
	}

	public void listar() {
		// Imprime todas as sess�es disponiveis;
	}

}
