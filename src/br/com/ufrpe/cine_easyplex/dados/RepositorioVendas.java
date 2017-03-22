package br.com.ufrpe.cine_easyplex.dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import br.com.ufrpe.cine_easyplex.interfaces.iRepositorioVendas;
import br.com.ufrpe.cine_easyplex.negocio.beans.Venda;

public class RepositorioVendas implements iRepositorioVendas, Serializable{
	private ArrayList<Venda> vendas;
	
	private static iRepositorioVendas instancia;
	
	public static synchronized iRepositorioVendas getInstance(){
		if(instancia == null){
			instancia = lerArquivo();
		}
		return instancia;
	}
	
	private RepositorioVendas() {
		this.vendas = new ArrayList<Venda>();
	}
	
	public static RepositorioVendas lerArquivo() {
		RepositorioVendas instancia = null;
		File in = new File("Vendas.dat");
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        
        try {
            fis = new FileInputStream(in);
            ois = new ObjectInputStream(fis);
            
            Object o = ois.readObject();
            instancia = (RepositorioVendas) o;
            
        } catch (Exception e) {
            instancia = new RepositorioVendas();
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
		File out = new File("Vendas.dat");
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
	
	public void inserir(Venda venda) {
		this.vendas.add(venda);
		this.salvarArquivo();
		
	}
	public boolean remover(int idVenda){
		Venda venda = this.pesquisar(idVenda);
		if(venda != null){
			this.vendas.remove(venda);
			this.salvarArquivo();
			return true;
		}
		return false;
	}

	
	public Venda pesquisar(int idVenda) {
		for(int i = 0; i < this.vendas.size(); i++){
			if(idVenda == this.vendas.get(i).getIdVenda()){
				return this.vendas.get(i);
			}
		}
		return null;
	}

	@Override
	public ArrayList<Venda> listar() {
		return this.vendas;
	}

	
	
	
	
}
