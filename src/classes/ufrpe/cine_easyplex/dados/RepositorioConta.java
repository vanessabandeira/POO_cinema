package classes.ufrpe.cine_easyplex.dados;

import classes.ufrpe.cine_easyplex.interfaces.iRepositorioContas;

import java.io.Serializable;
import java.util.ArrayList;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import classes.ufrpe.cine_easyplex.beans.Conta;

@SuppressWarnings("serial")
public class RepositorioConta implements iRepositorioContas, Serializable{
	
	
	private ArrayList<Conta> repositorio;
	private static RepositorioConta instance;
	
	//private int numerocontas;
	//private Conta[] contas;
	
	private RepositorioConta()
	{
		this.repositorio = new ArrayList<Conta>();
		Conta user = new Conta("user", "2017");
		repositorio.add(user);
	}
	
	public static RepositorioConta lerArquivo()
	{
		RepositorioConta instancia = null;
		File in = new File("Conta.dat");
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
        return instance;
        
	}
	
	public void salvarArquivo(){
		File out = new File("Conta.dat");
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        
        try {
            fos = new FileOutputStream(out);
            oos = new ObjectOutputStream(fos);
            
			oos.writeObject(instance);
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

	public static RepositorioConta getInstance() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	}
