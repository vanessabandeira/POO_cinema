package classes.ufrpe.cine_easyplex.dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import classes.ufrpe.cine_easyplex.Exceptions.PosicaoOcupadaException;
import classes.ufrpe.cine_easyplex.Exceptions.ValorInvalidoException;
import classes.ufrpe.cine_easyplex.beans.Venda;
import classes.ufrpe.cine_easyplex.interfaces.iRepositorioVendas;

public class RepositorioVendas implements iRepositorioVendas{
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
	
	public boolean inserir(Venda venda) throws ValorInvalidoException, PosicaoOcupadaException{
		if(venda.getQtdIngressos() != 0){
			if(venda.getIndiceLugar().size()==venda.getQtdIngressos()){
				if(venda.getQtdMeias()<=venda.getQtdIngressos()){
					int conferir = 0;
					for(int i = 0; i < venda.getIndiceLugar().size(); i++){
						if(venda.getSessao().conferirOcupacao(venda.getIndiceLugar().get(i))){
							conferir++;
						}
					}
					if(conferir == venda.getIndiceLugar().size()){
						venda.setIdVenda(this.vendas.size()+1);
						for(int i = 0; i < venda.getIndiceLugar().size(); i++){
							venda.getSessao().getPosicao()[venda.getIndiceLugar().get(i)] = false;
						}
						this.vendas.add(venda);
						this.salvarArquivo();
						return true;
					}
					else{
						throw new PosicaoOcupadaException();
					}
				}else throw new ValorInvalidoException("meias");
			}else throw new ValorInvalidoException("lugares");
		}else throw new ValorInvalidoException("ingressos");
		
	}
	public boolean remover(int idVenda) throws ValorInvalidoException{
		Venda venda = this.pesquisar(idVenda);
		if(venda != null){
			for(int i = 0; i < venda.getIndiceLugar().size(); i++){
				if(venda.getSessao().getPosicao()[venda.getIndiceLugar().get(i)]){
					this.vendas.remove(venda);
					this.salvarArquivo();
					return true;
				}
			}
		}
		throw new ValorInvalidoException("venda");
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
