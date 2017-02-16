package classes.ufrpe.cine_easyplex.dados;

import classes.ufrpe.cine_easyplex.beans.Filme;
import classes.ufrpe.cine_easyplex.beans.Sessao;
import java.util.ArrayList;

public class RepositorioSessao {
	private ArrayList<Sessao> sessoes;
	
	/*
	 * public RepositorioSessao{ M�TODO CONSTRUTOR }
	 */
	
	public RepositorioSessao(){
		this.sessoes = new ArrayList<Sessao>();
	}

	public boolean inserir(Sessao sessao) {
		if (sessao != null) {
			int search = pesquisar(sessao);
			if (search == -1) {
				this.sessoes.add(sessao);
				return true;
			}
		}
		return false;
	}

	public boolean remover(Sessao sessao) {
		int search = pesquisar(sessao);
		if (search != -1) {
			this.sessoes.remove(sessao);
			return true;
		}
		return false;

	}
	
	public boolean alterar (Sessao sessao) {
		int search = pesquisar(sessao);
		if(search!=-1){
			this.sessoes.set(search, sessao);
			return true;
		}
		return false;
		
	}
	
	public int pesquisar(Sessao sessao){
		return this.sessoes.indexOf(sessao);
	}

	public void pesquisarHorario(/* HoraInicio, HoraFim */) {
		// recebe horario de inicio e fim e imprime sess�es dispon�veis entre o
		// per�odo,
		// caso horafim seja NULL, imprimir� todas as sess�es dispon�veis ap�s o
		// horario de inicio
		// HoraIn�cio n�o pode ser NULL
		
	}

	

	public ArrayList listar() {
		return this.sessoes;
	}

}
