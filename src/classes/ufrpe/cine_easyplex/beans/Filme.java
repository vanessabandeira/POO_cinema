package classes.ufrpe.cine_easyplex.beans;

public class Filme {
	private String titulo;
	private int classificacao;
	private String genero;
	private int duracao;
	private int nvendas;
	

	public Filme(String titulo, int classificacao, String genero, int duracao) {
		this.titulo = titulo;
		this.classificacao = classificacao;
		this.genero = genero;
		this.duracao = duracao;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getClassificacao() {
		return classificacao;
	}

	public void setClassificacao(int classificacao) {
		this.classificacao = classificacao;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public int getDuracao() {
		return duracao;
	}

	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}

	@Override
	public String toString() {
		return "Filme [titulo=" + titulo + ", classificacao=" + classificacao + ", genero=" + genero + ", duracao="
				+ duracao + ", nvendas=" + nvendas + "]";
	}
	
	public boolean equals(Filme filme){
		if(this.titulo.equals(filme.titulo)){
			return true;
		}
		return false;
	}
	

}
