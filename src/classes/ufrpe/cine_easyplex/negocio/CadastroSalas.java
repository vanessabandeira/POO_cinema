package classes.ufrpe.cine_easyplex.negocio;

import classes.ufrpe.cine_easyplex.beans.Sala;
import classes.ufrpe.cine_easyplex.dados.RepositorioSalas;

public class CadastroSalas {
	RepositorioSalas repositorioSalas;
	
	public void adicionarSala(Sala sala){
		boolean adicionar = this.repositorioSalas.inserir(sala);
		if(adicionar){
			//mensagem de filme adicionado com sucesso
		}
		else{
			//mensagem de erro
		}
		
	}
	public void removerSala(Sala sala){
		boolean remover = this.repositorioSalas.remover(sala);
		if(remover){
			//mensagem de filme removido com sucesso
		}
		else{
			//mensagem de erro
		}
		
	}
	public Sala procurarId(){
		
	}
	public Sala procurarTipo(){
		
	}

}
