package br.com.ufrpe.cine_easyplex.gui;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import br.com.ufrpe.cine_easyplex.negocio.beans.Filme;
import br.com.ufrpe.cine_easyplex.negocio.beans.Sala;
import br.com.ufrpe.cine_easyplex.utils.exceptions.ValorInvalidoException;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;

public class RemoverSalaController implements Initializable {
	@FXML
	private TableView<Sala> tableView;
	@FXML 
	private TableColumn<Sala,Integer> listaID =  new TableColumn<>("identidade");
	@FXML 
	private TableColumn<Sala,String> listaTipo = new TableColumn<>("tipo");
	
	private Sala salaselecionada;
	Fachada fachada = Fachada.getInstancia();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
	
	public void preencherTabela(){
		listaID.setCellValueFactory(new PropertyValueFactory<Sala, Integer>("identidade"));
		listaTipo.setCellValueFactory(new PropertyValueFactory<Sala, String>("tipo"));
		
        tableView.setItems(FXCollections.observableArrayList(Fachada.getInstancia().getSalas().getRepositorioSalas().listar()));
        tableView.refresh();
	}
	
	public void remover() throws ValorInvalidoException {
		salaselecionada = tableView.getSelectionModel().getSelectedItem();
		if (salaselecionada != null) {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("CineEasyPlex");
			alert.setHeaderText("Deseja remover a sala " + salaselecionada.toString() + " ?");
			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK) {
				for(int i = 0; i < fachada.getSessoes().getRepositorioSessao().listar().size(); i++){
					if(fachada.getSessoes().getRepositorioSessao().listar().get(i).getExibicao().toString().equals(salaselecionada.toString())){
						fachada.getSessoes().removerSessao(fachada.getSessoes().getRepositorioSessao().listar().get(i));
					}
				}
				Fachada.getInstancia().removerSala(salaselecionada);
				preencherTabela();
				
			}
		}
	}
	
	public void backToMenu(){
		try{
			ScreenManager.getInstance().getMenu();
			System.out.println("sucesso");
		}
		catch(Exception e){
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("CineEasyPlex");
			alert.setHeaderText(e.getMessage());
			alert.showAndWait();
		}
	}
	
	public void sair(){
		try{
			ScreenManager.getInstance().getTelaLogin();
			System.out.println("sucesso");
		}
		catch(Exception e){
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("CineEasyPlex");
			alert.setHeaderText(e.getMessage());
			alert.showAndWait();
		}
	}
	

}
