package br.com.ufrpe.cine_easyplex.utils.comparadores;

import java.util.Comparator;

import br.com.ufrpe.cine_easyplex.negocio.beans.Filme;

public class ComparadorFilme implements Comparator<Filme>{

	@Override
	public int compare(Filme arg0, Filme arg1) {
		return arg0.getTitulo().compareTo(arg1.getTitulo());
	}

}
