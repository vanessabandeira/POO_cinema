package classes.ufrpe.cine_easyplex.beans;

import java.io.Serializable;

public class Sala implements Serializable {

	private int identidade;
	private boolean v3d;
	private boolean v4k;
	private String tipo;
	
	public Sala(int capacidade, int identidade, boolean v3d, boolean v4k, boolean prime){
		this.identidade=identidade;
		this.v3d=v3d;
		this.v4k=v4k;
		
	}

	public Sala() {
		super();
	}
	
	public void setTipo(){
		if(this.v3d && this.v4k){
			this.tipo = "Prime";
		}
		else if(this.v3d && !(this.v4k)){
			this.tipo = "3D";
		}
		else if(!(this.v3d) && this.v4k){
			this.tipo = "4K";
		}
		else{
			this.tipo = "Comum";
		}
	}

	public int getIdentidade() {
		return identidade;
	}

	public void setIdentidade(int identidade) {
		this.identidade = identidade;
	}

	public boolean isV3d() {
		return v3d;
	}

	public void setV3d(boolean v3d) {
		this.v3d = v3d;
	}

	public boolean isV4k() {
		return v4k;
	}
	
	public String getTipo(){
		return this.tipo;
	}

	public void setV4k(boolean v4k) {
		this.v4k = v4k;
	}
	
	public boolean equals(Sala sala){
		if(this.identidade == sala.identidade){
			return true;
		}
		return false;
		
	}

}
