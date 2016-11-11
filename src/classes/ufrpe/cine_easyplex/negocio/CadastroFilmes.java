package classes.ufrpe.cine_easyplex.negocio;

import classes.ufrpe.cine_easyplex.beans.Filme;
import classes.ufrpe.cine_easyplex.dados.RepositorioFilmes;

public class CadastroFilmes {
	RepositorioFilmes repositorioFilmes;
	
	public void adicionarFilme(Filme filme){
		boolean adicionar = this.repositorioFilmes.inserir(filme);
		if(adicionar){
			//mensagem de filme adicionado com sucesso
		}
		else{
			//mensagem de erro
		}
		
	}
	public void removerFilme(Filme filme){
		boolean remover = this.repositorioFilmes.remover(filme);
		if(remover){
			//mensagem de filme removido com sucesso
		}
		else{
			//mensagem de erro
		}
		
	}
	public boolean existe(Filme filme){
		int existir = this.repositorioFilmes.pesquisarIndice(filme);
		if(existir!=-1){
			return true;
		}
		else{
			return false;
		}
	}

}
