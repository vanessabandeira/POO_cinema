package br.com.ufrpe.cine_easyplex.gui;

import java.util.Optional;

import br.com.ufrpe.cine_easyplex.negocio.beans.Filme;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class AdicionarFilmesController {
	@FXML ObservableList<String> classificacaoList = FXCollections.observableArrayList("L","10","12","14","16","18");
	@FXML ObservableList<String> generoList = FXCollections.observableArrayList("Ação","Animação","Cinema catástrofe","Comédia","Drama","Documentário","Erótico","Fantasia",
			"Ficção científica","Ficção histórica","Guerra","Musical","Romance","Suspense","Terror");
	@FXML TextField tfTitulo, tfDuracao;
	@FXML Label lblError;
	@FXML ChoiceBox<String> classificacaoBox;
	@FXML ChoiceBox<String> generoBox;
	
	@FXML
	public void initialize() {
		classificacaoBox.setValue("L");
		classificacaoBox.setItems(classificacaoList);
		generoBox.setValue("Ação");
		generoBox.setItems(generoList);
		
	}
	
	public void adicionar(){
		try{
			Filme filme = new Filme();
			filme.setTitulo(tfTitulo.getText());
			filme.setDuracao(Integer.valueOf(tfDuracao.getText()));
			filme.setClassificacao(classificacaoBox.getValue());
			filme.setGenero(generoBox.getValue());
			Fachada.getInstancia().getFilmes().adicionarFilme(filme);
			//lblError.setText("Adicionado com sucesso!");
			tfTitulo.clear();
			classificacaoBox.setValue("L");
			generoBox.setValue("Ação");
			tfDuracao.clear();
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("CineEasyPlex");
			alert.setHeaderText(null);
			alert.setContentText(filme.getTitulo() + " foi adicionado com sucesso.");
			alert.showAndWait();
			
		}
		catch(Exception e){
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("CineEasyPlex");
			alert.setHeaderText("NOTAÇÃO INVÁLIDA");
			alert.setContentText(" Digite apenas o número");
			alert.showAndWait();
			
		}
	}
	
	public void backToMenu(){
		try{
			ScreenManager.getInstance().getMenu();
			System.out.println("entrou aqui");
		}
		catch(Exception e){
			lblError.setText("adicionado");
		}
	}
	
	public void sair(){
		try{
			ScreenManager.getInstance().getTelaLogin();
			System.out.println("entrou aqui");
		}
		catch(Exception e){
			lblError.setText("adicionado");
		}
	}

	
	
}
