package classes.ufrpe.cine_easyplex.beans;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Sessao implements Serializable {
	private static final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss dd-MM-yyyy");
	private Filme exibicao;
	private Sala hall;
	private Date hinicio;
	private Date hfim;
	private boolean[] posicao;
	private int ocupacao;
	private float valor; // valor do ingresso inteiro

	/*
	 * public Sessao{ Mï¿½TODO CONSTRUTOR }
	 */
	public Sessao(Filme exibido, Sala sala, Date hinicio) {
		super();
		this.exibicao = exibido;
		this.hall = sala;
		this.hinicio = hinicio;
		this.hfim = (Date) this.hinicio.clone();
		this.hfim.setMinutes(this.hinicio.getMinutes() + this.exibicao.getDuracao());
		this.ocupacao = 0;
	}
	
	public boolean conferirOcupacao(int posicao){
		return this.posicao[posicao];
	}

	public void ocuparcadeira(int Poltrona) {
		this.posicao[Poltrona] = false;
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

	public int getOcupacao() {
		return ocupacao;
	}

	public void setOcupacao(int ocupacao) {
		this.ocupacao = ocupacao;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public boolean[] getPosicao() {
		return posicao;
	}

	public void setPosicao(boolean[] posicao) {
		this.posicao = posicao;
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

}
