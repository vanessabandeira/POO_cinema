package br.com.ufrpe.cine_easyplex.gui;

import br.com.ufrpe.cine_easyplex.negocio.beans.Filme;
import br.com.ufrpe.cine_easyplex.negocio.beans.Sala;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class EditarSalaController {
	@FXML TextField tfID, tfPesquisa;
	@FXML CheckBox check3d, check4k;

	private TableColumn<Sala,Integer> listaID;
	
	@FXML 
	private TableColumn<Sala, Boolean> lista3d;
	@FXML
	private TableColumn<Filme,Boolean> lista4k;
	@FXML Label lblError;
	private Sala sala;
	
	public void pesquisa(){
		this.lblError.setText("");
		try{
			this.sala = Fachada.getInstancia().getSalas().procurarId(Integer.valueOf(tfPesquisa.getText()));
		}
		catch(Exception e){
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("CineEasyPlex");
			alert.setHeaderText("NOTAÇÃO INVÁLIDA");
			alert.setContentText(" As salas são identificadas por números");
			alert.showAndWait();
		}
		
		if(sala == null){
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("CineEasyPlex");
			alert.setHeaderText(null);
			alert.setContentText(" A sala não existe");
			alert.showAndWait();
		}
		else{
			tfID.setText(""+this.sala.getIdentidade());
			check3d.setSelected(this.sala.isV3d());
			check4k.setSelected(this.sala.isV4k());
		}
		
	}
	
	public void editar(){
		try{
			sala.setIdentidade(Integer.valueOf(tfID.getText()));
			sala.setV3d(check3d.isSelected());
			sala.setV4k(check4k.isSelected());
			Fachada.getInstancia().getSalas().editarSala(sala);
			lblError.setText("Editado com sucesso!");
			tfID.clear();
			tfPesquisa.clear();
			check3d.setSelected(false);
			check4k.setSelected(false);
		}
		catch(NumberFormatException e){
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("CineEasyPlex");
			alert.setHeaderText("NOTAÇÃO INVÁLIDA");
			alert.setContentText(" Digite apenas números");
			alert.showAndWait();
		}
	}
	public void backToMenu(){
		try{
			tfID.clear();
			tfPesquisa.clear();
			check3d.setSelected(false);
			check4k.setSelected(false);
			ScreenManager.getInstance().getMenu();
			System.out.println("entrou aqui");
		}
		catch(Exception e){
			lblError.setText(e.getMessage());;
		}
	}
	
	public void sair(){
		try{
			tfID.clear();
			tfPesquisa.clear();
			check3d.setSelected(false);
			check4k.setSelected(false);
			ScreenManager.getInstance().getTelaLogin();
			System.out.println("entrou aqui");
		}
		catch(Exception e){
			lblError.setText(e.getMessage());;
		}
	}
	
}
