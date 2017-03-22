package classes.ufrpe.cine_easyplex.dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import classes.ufrpe.cine_easyplex.interfaces.iRepositorioSalas;
import classes.ufrpe.cine_easyplex.Exceptions.ValorInvalidoException;
import classes.ufrpe.cine_easyplex.beans.Sala;

public class RepositorioSalas implements iRepositorioSalas, Serializable{
	public 	ArrayList<Sala> salas;
	
	private static iRepositorioSalas instancia;
	
	public static synchronized iRepositorioSalas getInstance(){
		if(instancia == null){
			instancia = lerArquivo();
		}
		return instancia;
	}
	
	private RepositorioSalas(){
		this.salas = new ArrayList<Sala>();
	}
	
	public static RepositorioSalas lerArquivo() {
		RepositorioSalas instancia = null;
		File in = new File("Salas.dat");
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        
        try {
            fis = new FileInputStream(in);
            ois = new ObjectInputStream(fis);
            
            Object o = ois.readObject();
            instancia = (RepositorioSalas) o;
            
        } catch (Exception e) {
            instancia = new RepositorioSalas();
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
		File out = new File("Salas.dat");
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
	
	public boolean inserir(Sala sala) throws ValorInvalidoException{
			int search = pesquisar(sala);
			if(sala != null && search < 0){
				sala.setTipo();
				this.salas.add(sala);
				this.salvarArquivo();
				return true;
			}
			else throw new ValorInvalidoException("sala");
	}
	
	public int pesquisar(Sala sala){
		return this.salas.indexOf(sala);
	}
	
	public boolean remover(Sala sala){
		int search = pesquisar(sala);
		if(sala != null && search!=-1){
			this.salas.remove(sala);
			this.salvarArquivo();
			return true;
		}
		return false;
	}
	
	public int getNumerosalas(){
		return salas.size();
	}
	
	public Sala pesquisarSalaTipo(Sala sala){
		//esse metodo busca salas pelo tipo, ex: 3D, 4K, etc...
		return sala;
	}
	
	public boolean alterar(Sala sala){
		int search = pesquisar(sala);
		if(sala != null && search!=-1){
			this.salas.set(search, sala);
			this.salvarArquivo();
			return true;
		}
		return false;
	}
	
	public ArrayList<Sala> listar(){
		return this.salas;
	}
}