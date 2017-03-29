package br.com.ufrpe.cine_easyplex.negocio;

import br.com.ufrpe.cine_easyplex.dados.RepositorioFilmes;
import br.com.ufrpe.cine_easyplex.interfaces.iRepositorioFilmes;
import br.com.ufrpe.cine_easyplex.negocio.beans.Filme;
import br.com.ufrpe.cine_easyplex.utils.exceptions.FilmeExistenteException;
import br.com.ufrpe.cine_easyplex.utils.exceptions.ValorInvalidoException;

public class CadastroFilmes {
	private iRepositorioFilmes repositorioFilmes;
	
	public CadastroFilmes() {
		this.repositorioFilmes = RepositorioFilmes.getInstance();
	}
	
	public void adicionarFilme(Filme filme) throws ValorInvalidoException, FilmeExistenteException{
		boolean adicionar = this.repositorioFilmes.inserir(filme);
		if(adicionar){
			System.out.println("Adicionado com sucesso!");
		}
		else{
			System.out.println("Sorry, guy, mas n rola");
		}
		
	}
	public void removerFilme(Filme filme) throws ValorInvalidoException{
		this.repositorioFilmes.remover(filme);
		
	}
	
	public void editarFilme(Filme filme) throws ValorInvalidoException {
		this.repositorioFilmes.alterar(filme);
		System.out.println("Editado!");
		
	}
	
	public Filme buscarFilme(String nome){
		for(int i = 0; i<this.repositorioFilmes.listar().size(); i++){
			if(this.repositorioFilmes.listar().get(i).toString().equals(nome)){
				return this.repositorioFilmes.listar().get(i);
			}
		}
		return null;
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
