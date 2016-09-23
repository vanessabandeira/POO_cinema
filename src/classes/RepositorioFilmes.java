package classes;

public class RepositorioFilmes {
	private Filme[] filmes;
	private int numerofilmes;

	public RepositorioFilmes(int tam) {
		this.filmes = new Filme[tam];
		numerofilmes = 0;
	}

	public boolean inserir(Filme filme) {
		if (filme != null) {
			Filme search = new Filme();
			search = pesquisarnome(filme);
			if (search == null && numerofilmes == 100 && filme.getTitulo() != null) {
				this.filmes[numerofilmes].setTitulo(filme.getTitulo());
				this.filmes[numerofilmes].setClassificacao(filme.getClassificacao());
				this.filmes[numerofilmes].setGenero(filme.getGenero());
				this.filmes[numerofilmes].setDuracao(filme.getDuracao());
				this.numerofilmes++;
				return true;
			}
		}
		return false;
	}

	public boolean remover(Filme filme) {

	}

	public Filme pesquisarnome(Filme filme) {
		int i;
		for (i = 0; i < numerofilmes; i++) {
			if (this.filmes[i].getTitulo().equals(filmes[i].getTitulo())) {
				return filmes[i];
			}
		}
		return null;
	}

	public Filme pesquisargenero(Filme filme) {

	}

	public boolean alterar(Filme filme) {

	}

	void listar() {

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
