package classes.ufrpe.cine_easyplex.dados;

import java.util.ArrayList;

import classes.ufrpe.cine_easyplex.beans.Filme;

public class RepositorioFilmes {
	private ArrayList<Filme> filmes;

	public RepositorioFilmes() {
		this.filmes = new ArrayList();
	}

	public boolean inserir(Filme filme) {
		if (filme != null) {
			int search = pesquisar(filme);
			if (search == -1) {
				this.filmes.add(filme);
				return true;
			}
		}
		return false;
	}

	public boolean remover(Filme filme) {
		int search = pesquisar(filme);
		if (search != -1) {
			this.filmes.remove(filme);
			return true;
		}
		return false;

	}

	public int pesquisar(Filme filme) {
		return this.filmes.indexOf(filme);
	}

	public boolean alterar(Filme filme) {
		int search = pesquisar(filme);
		if(search!=-1){
			this.filmes.set(search, filme);
			return true;
		}
		return false;
		
	}

	public ArrayList<Filme> listar() {
		return this.filmes;

	}

	public ArrayList<Filme> getFilmes() {
		return filmes;
	}

	public void setFilmes(Filme filme, int posicao) {
		this.filmes.set(posicao, filme);
	}

}
