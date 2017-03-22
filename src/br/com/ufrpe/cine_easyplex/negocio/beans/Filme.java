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
	
	public Filme(){
		
	}

	public String getTitulo() {
		return titulo;
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

	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}

	@Override
	public String toString() {
		return " Título:" + titulo + " Classificação: " + classificacao + " Gênero: " + genero + " Duração:  "
				+ duracao + " Nº Vendas: " + nvendas + "";
	}
	
	public boolean equals(Filme filme){
		if(this.titulo.equals(filme.titulo)){
			return true;
		}
		return false;
	}
	

}
