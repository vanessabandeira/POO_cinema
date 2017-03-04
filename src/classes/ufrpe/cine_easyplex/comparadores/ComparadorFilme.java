package classes.ufrpe.cine_easyplex.comparadores;

import java.util.Comparator;

import classes.ufrpe.cine_easyplex.beans.Filme;

public class ComparadorFilme implements Comparator<Filme>{

	@Override
	public int compare(Filme arg0, Filme arg1) {
		return arg0.getTitulo().compareTo(arg1.getTitulo());
	}

}
