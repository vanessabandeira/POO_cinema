package classes.ufrpe.cine_easyplex.negocio;

import java.util.ArrayList;

import classes.ufrpe.cine_easyplex.beans.Sala;
import classes.ufrpe.cine_easyplex.dados.RepositorioSalas;

public class CadastroSalas {
	RepositorioSalas repositorioSalas;
	
	private static CadastroSalas instancia;
	
	public static synchronized CadastroSalas getInstance(){
		if(instancia == null){
			instancia = new CadastroSalas();
		}
		return instancia;
	}
	
	public CadastroSalas() {
		this.repositorioSalas = new RepositorioSalas();
	}
	public void adicionarSala(Sala sala){
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

}
