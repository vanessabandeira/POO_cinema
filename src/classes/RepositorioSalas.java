package classes;

public class RepositorioSalas {
	public Sala[] salas;
	private int numerosalas;
	
	public boolean inserir(Sala sala){
		if(sala != null){
			Sala search =  new Sala;
			search = pesquisarsalaID(sala);
			if(search == null && numerosalas < this.numerosalas.lenght-1 && sala.identidade>0){
				this.salas[numerosalas]=sala;
				return true;
			}
			return false;
		}
	}
	public Sala pesquisarsalaID(Sala sala){
		int i;
		for(i=0; i<numerosalas; i++){
			if(this.salas[i].identidade==sala.identidade){
				return salas[i];
			}
		}
		return null;
	}
	public int getNumerosalas(){
		return numerosalas;
	}
	public Sala pesquisarsalaTipo(Sala sala){
		//esse metodo busca salas pelo tipo, ex: 3D, 4K, etc...
		
	}
	public boolean alterar(Sala sala){
		
	}
	public void listar(){
		
	}
}