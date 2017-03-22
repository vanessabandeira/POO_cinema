package br.com.ufrpe.cine_easyplex.negocio.beans;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Sessao implements Serializable {
	private static final long serialVersionUID = 5529462629123733301L;
	private static final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss dd-MM-yyyy");
	private Filme exibicao;
	private Sala hall;
	private Date hinicio;
	private Date hfim;
	private float valor; // valor do ingresso inteiro
	private Boolean[] cadeiras = new Boolean[200];

	
	public Sessao(Filme exibido, Sala sala, Date hinicio, float valor) {
		super();
		this.exibicao = exibido;
		this.hall = sala;
		this.hinicio = hinicio;
		this.hfim = (Date) this.hinicio.clone();
		this.hfim.setMinutes(this.hinicio.getMinutes() + this.exibicao.getDuracao());
		this.valor=valor;
		
		for(int i=0; i<200; i++){
			cadeiras[i] = false;
		}
		
	}
	
	public void setCadeira(int i){
		this.cadeiras[i] = true;
	}
	
	public Boolean getCadeiraComprada(int i){
		if(this.cadeiras[i]){
			return true;
		}else{
			return false;
		}
	}

	public String getHinicio() {
		return sdf.format(this.hinicio);
	}

	public void setHinicio(Date hinicio) {
		this.hinicio = hinicio;
	}

	public String getHfim() {
		return sdf.format(this.hfim);
	}

	public void setHfim(Date hfim) {
		this.hfim = hfim;
	}

	public Filme getExibicao() {
		return exibicao;
	}

	public void setExibicao(Filme exibicao) {
		this.exibicao = exibicao;
	}

	public Sala getHall() {
		return hall;
	}

	public void setHall(Sala hall) {
		this.hall = hall;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public boolean equals(Sessao comparada) {
		if (this.exibicao.equals(comparada.exibicao)) {
			if (this.hinicio.equals(comparada.hinicio)) {
				if (this.hall.equals(comparada.hall)) {
					return true;
				}
			}
		}
		return false;
	}
	
	public String toString(){
		return "Sala: "+ this.hall.getIdentidade() + ", das " + this.getHinicio() + " até às " + this.getHfim();
	}

	public Date getHorario() {
		// TODO Auto-generated method stub
		return null;
	}

}
