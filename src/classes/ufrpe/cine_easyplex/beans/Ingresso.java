package classes.ufrpe.cine_easyplex.beans;

public class Ingresso {
	public Sessao sessao;
	public int indiceLugar;
	public Ingresso(Sessao sessao, int lugar){
		this.sessao = sessao;
		this.indiceLugar = lugar;
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
	
}
