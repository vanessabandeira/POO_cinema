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
import java.util.List;

import classes.ufrpe.cine_easyplex.beans.Sessao;
import classes.ufrpe.cine_easyplex.comparadores.ComparadorSessao;
import classes.ufrpe.cine_easyplex.interfaces.iRepositorioSessao;

public class RepositorioSessao implements iRepositorioSessao, Serializable{
	private static final long serialVersionUID = 6909618405924724329L;

	private ArrayList<Sessao> sessoes;
	
	private static iRepositorioSessao instancia;
	
	public static synchronized iRepositorioSessao getInstance(){
		if(instancia == null){
			instancia = lerArquivo();
		}
		return instancia;
	}
	private RepositorioSessao(){
		this.sessoes = new ArrayList<Sessao>();
	}
	
	public static RepositorioSessao lerArquivo() {
		RepositorioSessao instancia = null;
		File in = new File("Sessao.dat");
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        
        try {
            fis = new FileInputStream(in);
            ois = new ObjectInputStream(fis);
            
            Object o = ois.readObject();
            instancia = (RepositorioSessao) o;
            
        } catch (Exception e) {
            instancia = new RepositorioSessao();
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
		File out = new File("Sessao.dat");
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
	
	public boolean inserir(Sessao sessao) {
		if (sessao != null) {
			int search = pesquisar(sessao);
			if (search == -1) {
				this.sessoes.add(sessao);
				this.salvarArquivo();
				return true;
			}
		}
		return false;
	}

	public boolean remover(Sessao sessao) {
		int search = pesquisar(sessao);
		if (search != -1) {
			this.sessoes.remove(sessao);
			this.salvarArquivo();
			return true;
		}
		return false;

	}
	
	public boolean alterar (Sessao sessao) {
		int search = pesquisar(sessao);
		if(search!=-1){
			this.sessoes.set(search, sessao);
			this.salvarArquivo();
			return true;
		}
		return false;
		
	}

	public int pesquisar(Sessao sessao){
		return this.sessoes.indexOf(sessao);
	}

	public void pesquisarHorario(/* HoraInicio, HoraFim */) {
		// recebe horario de inicio e fim e imprime sess�es dispon�veis entre o
		// per�odo,
		// caso horafim seja NULL, imprimir� todas as sess�es dispon�veis ap�s o
		// horario de inicio
		// HoraIn�cio n�o pode ser NULL
		
	}

	public List<Sessao> listar() {
		List<Sessao> listaOrdenada = this.sessoes;
		//Collections.sort(listaOrdenada, new ComparadorSessao());
		return listaOrdenada;
	}

}
