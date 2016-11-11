package classes.ufrpe.cine_easyplex.dados;

import classes.ufrpe.cine_easyplex.beans.Filme;

public class RepositorioFilmes {
	private Filme[] filmes;
	private int numerofilmes;

	public RepositorioFilmes(int tam) {
		this.filmes = new Filme[tam];
		numerofilmes = 0;
	}

	public boolean inserir(Filme filme) {
		if (filme != null) {
			int search = pesquisarIndice(filme);
			if (search == -1 && numerofilmes != this.numerofilmes-1 && filme.getTitulo() != null) {
				this.filmes[numerofilmes]=filme;
				return true;
			}
		}
		return false;
	}

	public boolean remover(Filme filme) {
		int search = pesquisarIndice(filme);
		if(search!=-1){
			this.filmes[search]=null;
			this.filmes[search]=this.filmes[numerofilmes];
			numerofilmes--;
			return true;
		}
		return false;

	}

	public int pesquisarIndice(Filme filme) {
		int i;
		for (i = 0; i < numerofilmes; i++) {
			if (this.filmes[i].getTitulo().equals(filmes[i].getTitulo())) {
				return i;
			}
		}
		return -1;
	}

	public boolean alterar(Filme filme) {
		int search = pesquisarIndice(filme);
		if(search!=-1){
			this.filmes[search]=filme;
			return true;
		}
		return false;
		
	}

	public Filme[] listar() {
		return this.filmes;

	}

	public Filme[] getFilmes() {
		return filmes;
	}

	public void setFilmes(Filme[] filmes) {
		this.filmes = filmes;
	}

	public int getNumerofilmes() {
		return numerofilmes;
	}

	public void setNumerofilmes(int numerofilmes) {
		this.numerofilmes = numerofilmes;
	}

}
