package br.com.ufrpe.cine_easyplex.gui;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class ArrecadacaoController{
	
	@FXML TextField tfTotalDia, tfTotalTotal;
	
	public void initialize(){
		tfTotalDia.setText(""+Fachada.getInstancia().getVendas().arrecadacaoDia());
		tfTotalTotal.setText(""+Fachada.getInstancia().getVendas().arrecadacao());
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
