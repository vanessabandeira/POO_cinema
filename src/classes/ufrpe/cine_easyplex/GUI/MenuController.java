package classes.ufrpe.cine_easyplex.GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import classes.ufrpe.cine_easyplex.beans.Filme;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;

public class MenuController implements Initializable {
	
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
	
	public void comprar(){
		
	}
	
	public void opcoes(){
		try{
			ScreenManager.getInstance().getOpcoes();
			System.out.println("entrou aqui");
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	public void sair(){
		try{
			ScreenManager.getInstance().getTelaLogin();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		
	}
}
