package br.com.ufrpe.cine_easyplex.gui;


import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ArrecadacaoController{
	
	@FXML Label  lblTotalTotal;
	
	public void initialize(){
		double valorTotalArrecadado = 0;
		for(int i = 0; i<Fachada.getInstancia().getVendas().getRepositorioVendas().listar().size(); i++){
			valorTotalArrecadado+=Fachada.getInstancia().getVendas().getRepositorioVendas().listar().get(i).calcularPreco();
		}
		lblTotalTotal.setText("R$ "+valorTotalArrecadado);
	}
	
	public void backToMenu(){
		try{
			ScreenManager.getInstance().getMenu();
			System.out.println("entrou aqui");
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	public void sair(){
		try{
			ScreenManager.getInstance().getTelaLogin();
			System.out.println("entrou aqui");
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
}
