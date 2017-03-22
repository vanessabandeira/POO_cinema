package br.com.ufrpe.cine_easyplex.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ArrecadacaoController{
	
	@FXML Label lblTotalDia, lblTotalTotal;
	
	public void initialize(){
		lblTotalDia.setText("R$ "+Fachada.getInstancia().getVendas().arrecadacaoDia());
		lblTotalTotal.setText("R$ "+Fachada.getInstancia().getVendas().arrecadacao());
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
