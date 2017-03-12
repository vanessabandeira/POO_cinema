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

import classes.ufrpe.cine_easyplex.dados.*;

public class Fachada implements Serializable {

	private CadastroContas contas;
	private CadastroFilmes filmes;
	private CadastroSalas salas;
	private CadastroSessao sessoes;
	private RepositorioVendas vendas;

	private static Fachada instancia = null;

	public Fachada(){
		this.instancia = lerArquivo();
		//Implementar Cadastro de COntas
		this.filmes.getInstance();
		this.salas = new CadastroSalas();
		this.sessoes.getInstance();
		this.vendas = vendas;
	}

	public Fachada getInstancia() {
		if (instancia == null) {
			instancia = new Fachada();
		}
		return instancia;
	}

	private Fachada lerArquivo() {
		this.instancia = null;
		File in = new File("Fachada.dat");
		FileInputStream fis = null;
		ObjectInputStream ois = null;

		try {
			fis = new FileInputStream(in);
			ois = new ObjectInputStream(fis);

			Object o = ois.readObject();
			this.instancia = (Fachada) o;

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

}
