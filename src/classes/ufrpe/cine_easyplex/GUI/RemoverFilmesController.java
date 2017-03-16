package classes.ufrpe.cine_easyplex.GUI;

import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;


import classes.ufrpe.cine_easyplex.beans.Filme;
import classes.ufrpe.cine_easyplex.dados.RepositorioFilmes;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;

public class RemoverFilmesController implements Initializable {
	
	@FXML
	private TableView<Filme> tableView;
	@FXML 
	private TableColumn<Filme,String> listaTitulo;
	@FXML 
	private TableColumn<Filme,String> listaGenero;
	@FXML 
	private TableColumn<Filme, Integer> listaDuracao;
	@FXML
	private TableColumn<Filme,Integer> listaClassificacao;
	
	private Filme filmeselecionado;
	private Fachada f;
	@FXML Label lblError;
	

	@Override
    public void initialize(URL arg0, ResourceBundle arg1) {
		
    }
	
	public void preencherTabela(){
		listaTitulo.setCellValueFactory(new PropertyValueFactory<Filme, String>("titulo"));
		listaGenero.setCellValueFactory(new PropertyValueFactory<Filme, String>("genero"));
		listaDuracao.setCellValueFactory(new PropertyValueFactory<Filme, Integer>("duracao"));
		listaClassificacao.setCellValueFactory(new PropertyValueFactory<Filme, Integer>("classificacao"));
		
        tableView.setItems(FXCollections.observableArrayList(Fachada.getInstancia().getFilmes().getRepositorioFilmes().listar()));
        tableView.refresh();
	}
	
	public void remover() {
		if (filmeselecionado != null) {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Remover filme");
			alert.setHeaderText("Deseja remover o filme?");
			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK) {
				ArrayList<Filme> aux = f.listarFilmes();
				aux.remove(filmeselecionado);
				preencherTabela();
				RepositorioFilmes.getInstance().salvarArquivo();
			}
		}
	}
	
	public void backToMenu(){
		try{
			ScreenManager.getInstance().getMenu();
			System.out.println("entrou aqui");
		}
		catch(Exception e){
			lblError.setText(e.getMessage());;
		}
	}
	
	public void sair(){
		try{
			ScreenManager.getInstance().getTelaLogin();
			System.out.println("entrou aqui");
		}
		catch(Exception e){
			lblError.setText(e.getMessage());;
		}
	}
	
}	
