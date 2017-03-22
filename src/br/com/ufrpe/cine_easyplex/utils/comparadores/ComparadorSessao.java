package br.com.ufrpe.cine_easyplex.utils.comparadores;

import java.util.Comparator;

import br.com.ufrpe.cine_easyplex.negocio.beans.Sessao;

public class ComparadorSessao implements Comparator<Sessao>{

	@Override
	public int compare(Sessao arg0, Sessao arg1) {
		return arg0.getHinicio().compareTo(arg1.getHinicio());
	}
	
}
