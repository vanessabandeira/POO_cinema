package classes.ufrpe.cine_easyplex.dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import classes.ufrpe.cine_easyplex.beans.Conta;
import classes.ufrpe.cine_easyplex.interfaces.iRepositorioContas;

@SuppressWarnings("serial")
public class RepositorioConta implements iRepositorioContas, Serializable{
	
	
	private ArrayList<Conta> contas;
	
	private static iRepositorioContas instancia;
	
	public static synchronized iRepositorioContas getInstance(){
		if(instancia == null){
			instancia = lerArquivo();
		}
		return instancia;
	}	
	private RepositorioConta()
	{
		Conta user = new Conta("admin","admin");
		this.contas = new ArrayList<Conta>();
		this.contas.add(user);
	}
	
	public static RepositorioConta lerArquivo()
	{
		RepositorioConta instancia = null;
		File in = new File("Contas.dat");
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        
        try {
            fis = new FileInputStream(in);
            ois = new ObjectInputStream(fis);
            
            Object o = ois.readObject();
            instancia = (RepositorioConta) o;
            
        } catch (Exception e) {
            instancia = new RepositorioConta();
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
		File out = new File("Contas.dat");
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

	public ArrayList<Conta> getContas() {
		return this.contas;
	}
	
	
}
