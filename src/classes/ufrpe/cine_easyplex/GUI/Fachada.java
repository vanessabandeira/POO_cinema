package classes.ufrpe.cine_easyplex.GUI;

import classes.ufrpe.cine_easyplex.negocio.*;

import classes.ufrpe.cine_easyplex.interfaces.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import classes.ufrpe.cine_easyplex.beans.Filme;
import classes.ufrpe.cine_easyplex.dados.*;

public class Fachada implements Serializable {

	private CadastroContas contas;
	private CadastroFilmes filmes;
	private CadastroSalas salas;
	private CadastroSessao sessoes;
	private RepositorioVendas vendas;

	private static Fachada instancia = null;

	private Fachada(){
		this.contas = new CadastroContas();
		this.filmes = new CadastroFilmes();
		this.salas = new CadastroSalas();
		this.vendas = vendas;
		this.sessoes = new CadastroSessao();
	}

	public static Fachada getInstancia() {
		if (instancia == null) {
			instancia = lerArquivo();
		}
		return instancia;
	}

	private static Fachada lerArquivo() {
		Fachada instancia = null;
		File in = new File("Fachada.dat");
		FileInputStream fis = null;
		ObjectInputStream ois = null;

		try {
			fis = new FileInputStream(in);
			ois = new ObjectInputStream(fis);

			Object o = ois.readObject();
			instancia = (Fachada) o;

		} catch (Exception e) {
			instancia = new Fachada();
		} finally {
			if (ois != null) {
				try {
					ois.close();
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
		}
		return instancia;
	}

	public void salvarArquivo() {
		File out = new File("Fachada.dat");
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;

		try {
			fos = new FileOutputStream(out);
			oos = new ObjectOutputStream(fos);

			oos.writeObject(instancia);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (oos != null) {
				try {
					oos.close();
				} catch (IOException e) {

				}
			}
		}
	}

	public CadastroContas getContas() {
		return contas;
	}

	public void setContas(CadastroContas contas) {
		this.contas = contas;
	}

	public CadastroFilmes getFilmes() {
		return filmes;
	}

	public void setFilmes(CadastroFilmes filmes) {
		this.filmes = filmes;
	}

	public CadastroSalas getSalas() {
		return salas;
	}

	public void setSalas(CadastroSalas salas) {
		this.salas = salas;
	}

	public CadastroSessao getSessoes() {
		return sessoes;
	}

	public void setSessoes(CadastroSessao sessoes) {
		this.sessoes = sessoes;
	}

	public RepositorioVendas getVendas() {
		return vendas;
	}

	public void setVendas(RepositorioVendas vendas) {
		this.vendas = vendas;
	}

	public static void setInstancia(Fachada instancia) {
		Fachada.instancia = instancia;
	}

	public ArrayList<Filme> listarFilmes() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
