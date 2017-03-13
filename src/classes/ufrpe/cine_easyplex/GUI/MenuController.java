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
	
	private TableView<Filme> tableView;
	@FXML TableColumn<Filme,String> listaTitulo;
	@FXML TableColumn<Filme,String> listaGenero;
	@FXML TableColumn<Filme, Integer> listaDuracao;
	@FXML TableColumn<Filme,Integer> listaClassificacao;
	private Fachada fachada = Fachada.getInstancia();
	ObservableList<Filme> filmes = FXCollections.observableArrayList(this.fachada.getFilmes().getRepositorioFilmes().listar());

	@Override
    public void initialize(URL arg0, ResourceBundle arg1) {
		
    }
	
	public void preencherTabela(){
		listaTitulo.setCellValueFactory(new PropertyValueFactory<Filme, String>("titulo"));
		listaGenero.setCellValueFactory(new PropertyValueFactory<Filme, String>("genero"));
		listaDuracao.setCellValueFactory(new PropertyValueFactory<Filme, Integer>("duracao"));
		listaClassificacao.setCellValueFactory(new PropertyValueFactory<Filme, Integer>("classificao"));
		
        tableView.setItems(this.filmes);
	}
	
	public void comprar(){
		
	}
	
	public void opcoes(){
		try{
			URL paneUrl = getClass().getResource("Opcoes.fxml"); 
			BorderPane pane = FXMLLoader.load( paneUrl );     
			BorderPane border = Main.getRoot(); 
			border.setCenter(pane);
			System.out.println("entrou aqui");
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	public void sair(){
		try{
			URL paneUrl = getClass().getResource("TelaLogin.fxml"); 
			BorderPane pane = FXMLLoader.load( paneUrl );     
			BorderPane border = Main.getRoot(); 
			border.setCenter(pane);
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		
	}
}
