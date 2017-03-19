package classes.ufrpe.cine_easyplex.negocio;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import classes.ufrpe.cine_easyplex.beans.Filme;
import classes.ufrpe.cine_easyplex.beans.Sala;
import classes.ufrpe.cine_easyplex.beans.Sessao;
import classes.ufrpe.cine_easyplex.dados.RepositorioSessao;
import classes.ufrpe.cine_easyplex.interfaces.iRepositorioSessao;

public class CadastroSessao {
	private iRepositorioSessao repositorioSessao;
	
	public CadastroSessao() {
		this.repositorioSessao = RepositorioSessao.getInstance();
	}
	
	public void adicionarSessao(Sessao sessao){
		this.repositorioSessao.inserir(sessao);
	}
	public void cancelarSessao(Sessao sessao){
		this.repositorioSessao.remover(sessao);
	}
	public boolean conferirHorario(){
		return true;
	}
	public ArrayList<Sessao> buscarPorFilme(Filme filme){
		ArrayList<Sessao> listaPorFilme = new ArrayList<>();
		for(int i = 0; i<this.repositorioSessao.listar().size() ;i++){
			if(this.repositorioSessao.listar().get(i).getExibicao().equals(filme)){
				listaPorFilme.add(this.repositorioSessao.listar().get(i));
			}
		}
		return listaPorFilme;
		
	}
	public ArrayList<Sessao> buscarPorSala(Sala sala){
		ArrayList<Sessao> listaPorSala = new ArrayList<>();
		for(int i = 0; i<this.repositorioSessao.listar().size() ;i++){
			if(this.repositorioSessao.listar().get(i).getHall().equals(sala)){
				listaPorSala.add(this.repositorioSessao.listar().get(i));
			}
		}
		return listaPorSala;
		
	}
	
	public Sessao buscarPorHorario(){
		return null;
	}

	public iRepositorioSessao getRepositorioSessao() {
		return repositorioSessao;
	}

	public void setRepositorioSessao(iRepositorioSessao repositorioSessao) {
		this.repositorioSessao = repositorioSessao;
	}
	

}
