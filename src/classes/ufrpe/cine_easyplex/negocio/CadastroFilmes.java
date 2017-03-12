package classes.ufrpe.cine_easyplex.negocio;

import classes.ufrpe.cine_easyplex.beans.Filme;
import classes.ufrpe.cine_easyplex.dados.RepositorioFilmes;
import classes.ufrpe.cine_easyplex.interfaces.iRepositorioFilmes;

public class CadastroFilmes {
	private iRepositorioFilmes repositorioFilmes;
	
	public CadastroFilmes() {
		this.repositorioFilmes = RepositorioFilmes.getInstance();
	}
	
	public void adicionarFilme(Filme filme){
		boolean adicionar = this.repositorioFilmes.inserir(filme);
		if(adicionar){
			System.out.println("Adicionado com sucesso!");
		}
		else{
			System.out.println("Sorry, guy, mas n rola");
		}
		
	}
	public void removerFilme(Filme filme){
		boolean remover = this.repositorioFilmes.remover(filme);
		if(remover){
			System.out.println("Adicionado com sucesso!");
		}
		else{
			System.out.println("Sorry, guy, mas n rola");
		}
		
	}
	public boolean existe(Filme filme){
		int existir = this.repositorioFilmes.pesquisar(filme);
		if(existir!=-1){
			return true;
		}
		else{
			return false;
		}
	}

	public iRepositorioFilmes getRepositorioFilmes() {
		return this.repositorioFilmes;
	}

	public void setRepositorioFilmes(RepositorioFilmes repositorioFilmes) {
		this.repositorioFilmes = repositorioFilmes;
	}
	

}
