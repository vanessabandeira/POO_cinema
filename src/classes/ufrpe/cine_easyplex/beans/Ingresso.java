package classes.ufrpe.cine_easyplex.beans;

public class Ingresso {
	
	private Sessao sessao;
	private int indiceLugar;
	private boolean meia;
	
	public Ingresso(Sessao sessao, int lugar, boolean meia){
		this.sessao = sessao;
		this.indiceLugar = lugar;
		this.setMeia(meia);
	}
	
	public Sessao getSessao() {
		return sessao;
	}
	public int getIndiceLugar() {
		return indiceLugar;
	}
	public void setSessao(Sessao sessao) {
		this.sessao = sessao;
	}
	public void setIndiceLugar(int indiceLugar) {
		this.indiceLugar = indiceLugar;
	}
	
	public boolean equals(Ingresso comparado){
		if(comparado.sessao.equals(this.sessao)){
			if(this.indiceLugar == comparado.indiceLugar)
			return true;
		}
		
		return false;
	}

	public boolean getMeia() {
		return meia;
	}

	public void setMeia(boolean meia) {
		this.meia = meia;
	}
	
}
