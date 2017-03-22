package br.com.ufrpe.cine_easyplex.negocio.beans;

import java.io.Serializable;

public class Filme implements Serializable {
	private String titulo;
	private String classificacao;
	private String genero;
	private int duracao;
	private int nvendas;

	public Filme(String titulo, String classificacao, String genero, int duracao) {
		this.titulo = titulo;
		this.classificacao = classificacao;
		this.genero = genero;
		this.duracao = duracao;
	}

	public Filme() {

	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getClassificacao() {
		return classificacao;
	}

	public void setClassificacao(String classificacao) {
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
	
	
	public String getTitulo() {
		return titulo;
	}

	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}

	public String toString() {
		return this.titulo;
	}

	public boolean equals(Filme filme) {
		String a = this.titulo.toString();
		String b = filme.titulo.toString();
		a.toUpperCase();
		b.toUpperCase();
		if (a.toUpperCase().equals(b.toUpperCase())) {
			return true;
		}
		return false;
	}

}
