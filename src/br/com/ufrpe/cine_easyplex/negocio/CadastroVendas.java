package classes.ufrpe.cine_easyplex.negocio;

import java.util.Date;

import classes.ufrpe.cine_easyplex.Exceptions.PosicaoOcupadaException;
import classes.ufrpe.cine_easyplex.Exceptions.ValorInvalidoException;
import classes.ufrpe.cine_easyplex.beans.Venda;
import classes.ufrpe.cine_easyplex.dados.RepositorioVendas;
import classes.ufrpe.cine_easyplex.interfaces.iRepositorioVendas;

public class CadastroVendas {
	iRepositorioVendas repositorioVendas;
	
	public CadastroVendas()
	{
		this.repositorioVendas = RepositorioVendas.getInstance();
	}
	
	public void adicionarVenda(Venda venda) throws ValorInvalidoException, PosicaoOcupadaException{
		this.repositorioVendas.inserir(venda);
	}
	public void removerVenda(int idVenda) throws ValorInvalidoException{
		this.repositorioVendas.remover(idVenda);
	}
	
	public double arrecadacao(){
		double valorArrecadado = 0;
		for(int i = 0; i<this.repositorioVendas.listar().size(); i++){
			valorArrecadado+=this.repositorioVendas.listar().get(i).calcularPreco();
		}
		return valorArrecadado;
	}
	
	public double arrecadacaoDia(){
		double valorArrecadado = 0;
		Date data = new Date();
		for(int i = 0; i<this.repositorioVendas.listar().size(); i++){
			if(data.getMonth() == this.repositorioVendas.listar().get(i).getSessao().getDateInicio().getMonth()){
				if(data.getDay() == this.repositorioVendas.listar().get(i).getSessao().getDateInicio().getDay()){
					valorArrecadado+=this.repositorioVendas.listar().get(i).calcularPreco();
				}
			}
		}
		return valorArrecadado;
	}
	
}
