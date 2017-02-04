package classes.ufrpe.cine_easyplex.negocio;

import classes.ufrpe.cine_easyplex.beans.Filme;
import classes.ufrpe.cine_easyplex.dados.RepositorioFilmes;

public class CadastroFilmes {
	RepositorioFilmes repositorioFilmes;
	
	private static CadastroFilmes instancia;
	
	public static synchronized CadastroFilmes getInstance(){
		if(instancia == null){
			instancia = new CadastroFilmes();
		}
		return instancia;
	}
	
	private CadastroFilmes() {
		this.repositorioFilmes = new RepositorioFilmes();
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

	public RepositorioFilmes getRepositorioFilmes() {
		return repositorioFilmes;
	}

	public void setRepositorioFilmes(RepositorioFilmes repositorioFilmes) {
		this.repositorioFilmes = repositorioFilmes;
	}
	

}
