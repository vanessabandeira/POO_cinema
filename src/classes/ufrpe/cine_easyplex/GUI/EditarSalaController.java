package classes.ufrpe.cine_easyplex.GUI;

import classes.ufrpe.cine_easyplex.beans.Filme;
import classes.ufrpe.cine_easyplex.beans.Sala;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class EditarSalaController {
	@FXML TextField tfID, tfCapacidade, tfPesquisa;
	@FXML CheckBox check3d, check4k, checkPrime;

	private TableColumn<Sala,Integer> listaID;
	@FXML 
	private TableColumn<Sala,Integer> listaCapacidade;
	@FXML 
	private TableColumn<Sala, Boolean> lista3d;
	@FXML
	private TableColumn<Filme,Boolean> lista4k;
	@FXML
	private TableColumn<Filme,Boolean> listaPrime;
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
			alert.setHeaderText("NOTA��O INV�LIDA");
			alert.setContentText(" As salas s�o identificadas por n�meros");
			alert.showAndWait();
		}
		
		if(sala == null){
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("CineEasyPlex");
			alert.setHeaderText(null);
			alert.setContentText(" A sala n�o existe");
			alert.showAndWait();
		}
		else{
			tfID.setText(""+this.sala.getIdentidade());
			tfCapacidade.setText(""+this.sala.getCapacidade());
			check3d.setSelected(this.sala.isV3d());
			check4k.setSelected(this.sala.isV4k());
			checkPrime.setSelected(this.sala.isPrime());
		}
		
	}
	
	public void editar(){
		try{
			sala.setCapacidade(Integer.valueOf(tfCapacidade.getText()));
			sala.setIdentidade(Integer.valueOf(tfID.getText()));
			sala.setPrime(checkPrime.isSelected());
			sala.setV3d(check3d.isSelected());
			sala.setV4k(check4k.isSelected());
			Fachada.getInstancia().getSalas().editarSala(sala);
			lblError.setText("Editado com sucesso!");
			tfID.clear();
			tfCapacidade.clear();
			tfPesquisa.clear();
			check3d.setSelected(false);
			check4k.setSelected(false);
			checkPrime.setSelected(false);
		}
		catch(NumberFormatException e){
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("CineEasyPlex");
			alert.setHeaderText("NOTA��O INV�LIDA");
			alert.setContentText(" Digite apenas n�meros");
			alert.showAndWait();
		}
	}
	public void backToMenu(){
		try{
			tfID.clear();
			tfCapacidade.clear();
			tfPesquisa.clear();
			check3d.setSelected(false);
			check4k.setSelected(false);
			checkPrime.setSelected(false);
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
			tfCapacidade.clear();
			tfPesquisa.clear();
			check3d.setSelected(false);
			check4k.setSelected(false);
			checkPrime.setSelected(false);
			ScreenManager.getInstance().getTelaLogin();
			System.out.println("entrou aqui");
		}
		catch(Exception e){
			lblError.setText(e.getMessage());;
		}
	}
	
}
