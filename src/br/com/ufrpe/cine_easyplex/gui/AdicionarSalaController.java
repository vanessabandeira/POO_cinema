package br.com.ufrpe.cine_easyplex.gui;

import br.com.ufrpe.cine_easyplex.negocio.beans.Sala;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class AdicionarSalaController {
	
	@FXML TextField tfID;
	@FXML CheckBox check3d, check4k; 
	@FXML Label lblError;
	
	public void adicionar(){
		try{
			
			Sala sala = new Sala();
			sala.setIdentidade(Integer.valueOf(tfID.getText()));
			sala.setV3d(check3d.isSelected());
			sala.setV4k(check4k.isSelected());
			Fachada.getInstancia().getSalas().adicionarSala(sala);
			tfID.clear();
			check3d.setSelected(false);
			check4k.setSelected(false);
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("CineEasyPlex");
			alert.setHeaderText("Adicionada com sucesso");
			alert.setContentText(null);
			alert.showAndWait();
			
		}
		catch(NumberFormatException e){
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("CineEasyPlex");
			alert.setHeaderText("NOTAÇÃO INVÁLIDA");
			alert.setContentText(" Digite apenas o número");
			alert.showAndWait();
		}
		catch(Exception e){ 
			
			lblError.setText(e.getMessage());
		}
	}
	
	public void backToMenu(){
		try{
			ScreenManager.getInstance().getMenu();
			System.out.println("entrou aqui");
		}
		catch(Exception e){
			lblError.setText(e.getMessage());
		}
	}
	
	public void sair(){
		try{
			ScreenManager.getInstance().getTelaLogin();
			System.out.println("entrou aqui");
		}
		catch(Exception e){
			lblError.setText(e.getMessage());
		}
	}
}
