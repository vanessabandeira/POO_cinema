package classes.ufrpe.cine_easyplex.dados;

import classes.ufrpe.cine_easyplex.beans.Filme;
import classes.ufrpe.cine_easyplex.beans.Sala;

public class RepositorioSalas {
	public Sala[] salas;
	private int numerosalas;
	
	public RepositorioSalas(int tam){
		this.salas = new Sala[tam];
		numerosalas = 0;
	}
	
	public boolean inserir(Sala sala){
			int search = pesquisar(sala);
			if(search == -1 && numerosalas < this.salas.length-1 && sala.getCapacidade()>0){
				this.salas[numerosalas]=sala;
				return true;
			}
			return false;
	}
	
	public int pesquisar(Sala sala){
		int i;
		for(i=0; i<numerosalas; i++){
			if(this.salas[i].getIdentidade()==sala.getIdentidade()){
				return i;
			}
		}
		return -1;
	}
	
	public boolean remover(Sala sala){
		int search = pesquisar(sala);
		if(search!=-1){
			this.salas[search]=null;
			this.salas[search]=this.salas[numerosalas];
			numerosalas--;
			return true;
		}
		return false;
	}
	
	public int getNumerosalas(){
		return numerosalas;
	}
	
	public Sala pesquisarsalaTipo(Sala sala){
		//esse metodo busca salas pelo tipo, ex: 3D, 4K, etc...
		return sala;
	}
	
	public boolean alterar(Sala sala){
		int search = pesquisar(sala);
		if(search!=-1){
			this.salas[search]=sala;
			return true;
		}
		return false;
	}
	
	public Sala[] listar(){
		return this.salas;
	}
}