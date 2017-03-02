package classes.ufrpe.cine_easyplex.dados;

import java.util.ArrayList;

import classes.ufrpe.cine_easyplex.beans.Sala;

public class RepositorioSalas {
	public 	ArrayList<Sala> salas;
	
	public RepositorioSalas(){
		this.salas = new ArrayList();
	}
	
	public boolean inserir(Sala sala){
			int search = pesquisar(sala);
			if(sala != null && search == -1 && sala.getCapacidade()>0){
				this.salas.add(sala);
				return true;
			}
			return false;
	}
	
	public int pesquisar(Sala sala){
		return this.salas.indexOf(sala);
	}
	
	public boolean remover(Sala sala){
		int search = pesquisar(sala);
		if(sala != null && search!=-1){
			this.salas.remove(sala);
			return true;
		}
		return false;
	}
	
	public int getNumerosalas(){
		return salas.size();
	}
	
	public Sala pesquisarSalaTipo(Sala sala){
		//esse metodo busca salas pelo tipo, ex: 3D, 4K, etc...
		return sala;
	}
	
	public boolean alterar(Sala sala){
		int search = pesquisar(sala);
		if(sala != null && search!=-1){
			this.salas.set(search, sala);
			return true;
		}
		return false;
	}
	
	public ArrayList<Sala> listar(){
		return this.salas;
	}
}