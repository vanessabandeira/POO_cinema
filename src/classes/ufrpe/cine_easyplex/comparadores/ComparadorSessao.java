package classes.ufrpe.cine_easyplex.comparadores;

import java.util.Comparator;

import classes.ufrpe.cine_easyplex.beans.Sessao;

public class ComparadorSessao implements Comparator<Sessao>{

	@Override
	public int compare(Sessao arg0, Sessao arg1) {
		return arg0.getHorario().compareTo(arg1.toString());
	}
	
}
