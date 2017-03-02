package classes.ufrpe.cine_easyplex.dados;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import classes.ufrpe.cine_easyplex.beans.Sessao;
import classes.ufrpe.cine_easyplex.comparadores.ComparadorSessao;
import classes.ufrpe.cine_easyplex.interfaces.iRepositorioSessao;

public class RepositorioSessao implements iRepositorioSessao{
	private ArrayList<Sessao> sessoes;
	
	private static RepositorioSessao instancia;
	
	public static synchronized RepositorioSessao getInstance(){
		if(instancia == null){
			instancia = new RepositorioSessao();
		}
		return instancia;
	}
	private RepositorioSessao(){
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

	public List<Sessao> listar() {
		List<Sessao> listaOrdenada = this.sessoes;
		Collections.sort(listaOrdenada, new ComparadorSessao());
		return listaOrdenada;
	}

}
