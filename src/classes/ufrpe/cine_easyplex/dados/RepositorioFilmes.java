package classes.ufrpe.cine_easyplex.dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

import classes.ufrpe.cine_easyplex.beans.Filme;
import classes.ufrpe.cine_easyplex.comparadores.ComparadorFilme;
import classes.ufrpe.cine_easyplex.interfaces.iRepositorioFilmes;

public class RepositorioFilmes implements iRepositorioFilmes, Serializable{
	
	private ArrayList<Filme> filmes;

	private static iRepositorioFilmes instancia;
	
	public static synchronized iRepositorioFilmes getInstance(){
		if(instancia == null){
			instancia = lerArquivo();
		}
		return instancia;
	}
	
	private RepositorioFilmes() {
		this.filmes = new ArrayList<Filme>();
	}
	
	public static RepositorioFilmes lerArquivo() {
		RepositorioFilmes instancia = null;
		File in = new File("Filmes.dat");
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        
        try {
            fis = new FileInputStream(in);
            ois = new ObjectInputStream(fis);
            
            Object o = ois.readObject();
            instancia = (RepositorioFilmes) o;
            
        } catch (Exception e) {
            instancia = new RepositorioFilmes();
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
	
	public void salvarArquivo(){
		File out = new File("Filmes.dat");
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

	public boolean inserir(Filme filme) {
		if (filme != null) {
			int search = pesquisar(filme);
			if (search == -1) {
				this.filmes.add(filme);
				this.salvarArquivo();
				return true;
			}
		}
		return false;
	}

	public boolean remover(Filme filme) {
		int search = pesquisar(filme);
		if (search != -1) {
			this.filmes.remove(filme);
			this.salvarArquivo();
			return true;
		}
		return false;

	}

	public int pesquisar(Filme filme) {
		return this.filmes.indexOf(filme);
	}

	public boolean alterar(Filme filme) {
		int search = pesquisar(filme);
		if(search!=-1){
			this.filmes.set(search, filme);
			this.salvarArquivo();
			return true;
		}
		return false;
		
	}

	public ArrayList<Filme> listar() {
		ArrayList<Filme> listaOrdenada = this.filmes;
		Collections.sort(listaOrdenada, new ComparadorFilme());
		return listaOrdenada;

	}

	public ArrayList<Filme> getFilmes() {
		return filmes;
	}

	public void setFilmes(Filme filme, int posicao) {
		this.filmes.set(posicao, filme);
	}
	

}
