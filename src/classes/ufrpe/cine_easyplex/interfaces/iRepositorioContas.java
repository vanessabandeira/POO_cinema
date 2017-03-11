package classes.ufrpe.cine_easyplex.interfaces;

import java.util.ArrayList;

import classes.ufrpe.cine_easyplex.beans.Conta;
import classes.ufrpe.cine_easyplex.dados.RepositorioConta;

public interface iRepositorioContas {
	
	public ArrayList<Conta> getContas();

}
