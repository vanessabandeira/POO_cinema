package br.com.ufrpe.cine_easyplex.negocio;

import br.com.ufrpe.cine_easyplex.dados.RepositorioSalas;
import br.com.ufrpe.cine_easyplex.interfaces.iRepositorioFilmes;
import br.com.ufrpe.cine_easyplex.interfaces.iRepositorioSalas;
import br.com.ufrpe.cine_easyplex.negocio.beans.Sala;
import br.com.ufrpe.cine_easyplex.utils.exceptions.ValorInvalidoException;

public class CadastroSalas {
	private iRepositorioSalas repositorioSalas;
	
	public CadastroSalas() {
		this.repositorioSalas = RepositorioSalas.getInstance();
	}
	public void adicionarSala(Sala sala) throws ValorInvalidoException{
		boolean adicionar = this.repositorioSalas.inserir(sala);
		if(adicionar){
			System.out.println("Adicionado com sucesso!");
		}
		else{
			System.out.println("Sorry, guy, mas n rola");
		}
		
	}
	public void removerSala(Sala sala){
		boolean remover = this.repositorioSalas.remover(sala);
		if(remover){
			System.out.println("Adicionado com sucesso!");
		}
		else{
			System.out.println("Sorry, guy, mas n rola");
		}
		
	}
	public Sala procurarId(int idSala){
		for(int i=0; i<this.repositorioSalas.listar().size();i++){
			if(idSala == this.repositorioSalas.listar().get(i).getIdentidade()){
				return this.repositorioSalas.listar().get(i);
			}
		}
		return  null;
		
	}
	public Sala procurarTipo(){
		return null;
	} 
	
	public void editarSala(Sala sala){
		this.repositorioSalas.alterar(sala);
	}
	public iRepositorioSalas getRepositorioSalas() {
		
		return this.repositorioSalas;
	}

}
