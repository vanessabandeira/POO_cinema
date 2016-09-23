package classes;

public class Sala {
	private Filme[] filmesdasala;
	private int capacidade;
	private int identidade;
	private boolean v3d;
	private boolean v4k;
	private boolean prime;

	public Filme[] getFilmesdasala() {
		return filmesdasala;
	}

	public void setFilmesdasala(Filme[] filmesdasala) {
		this.filmesdasala = filmesdasala;
	}

	public int getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
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

	public void setV4k(boolean v4k) {
		this.v4k = v4k;
	}

	public boolean isPrime() {
		return prime;
	}

	public void setPrime(boolean prime) {
		this.prime = prime;
	}

}
