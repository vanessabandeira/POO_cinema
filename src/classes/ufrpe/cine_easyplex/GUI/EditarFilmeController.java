package classes.ufrpe.cine_easyplex.GUI;

import classes.ufrpe.cine_easyplex.beans.Filme;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class EditarFilmeController {
	@FXML ObservableList<String> classificacaoList = FXCollections.observableArrayList("L","10","12","14","16","18");
	@FXML ObservableList<String> generoList = FXCollections.observableArrayList("Ação","Animação","Cinema catástrofe","Comédia","Drama","Documentário","Erótico","Fantasia",
			"Ficção científica","Ficção histórica","Guerra","Musical","Romance","Suspense","Terror");
	@FXML TextField tfPesquisa, tfTitulo, tfDuracao;
	@FXML Label lblError;
	private Filme filme;
	
	@FXML ChoiceBox<String> classificacaoBox;
	@FXML ChoiceBox<String> generoBox;
	

	public void pesquisar(){
		this.lblError.setText("");
		this.filme = Fachada.getInstancia().getFilmes().buscarFilme(tfPesquisa.getText());
		if(filme == null){
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("CineEasyPlex");
			alert.setHeaderText(null);
			alert.setContentText("FILME NÃO ENCONTRADO");
			alert.showAndWait();		}
		else{
			classificacaoBox.setValue(this.filme.getClassificacao());
			classificacaoBox.setItems(classificacaoList);
			generoBox.setValue(this.filme.getGenero());
			generoBox.setItems(generoList);
			tfTitulo.setText(this.filme.getTitulo());
			tfDuracao.setText(""+this.filme.getDuracao());
		}
		
	}
	
	public void comprar(){
		
	}
	
	public void concluir(){
		try{
			filme.setTitulo(tfTitulo.getText());
			filme.setDuracao(Integer.valueOf(tfDuracao.getText()));
			filme.setClassificacao(classificacaoBox.getValue());
			filme.setGenero(generoBox.getValue());
			Fachada.getInstancia().getFilmes().editarFilme(filme);
			tfTitulo.clear();
			classificacaoBox.setValue("L");
			generoBox.setValue("Ação");
			tfDuracao.clear();
			tfPesquisa.clear();
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("CineEasyPlex");
			alert.setHeaderText(null);
			alert.setContentText(filme.getTitulo() + " foi modificado com sucesso.");
			alert.showAndWait();
			
		}
		catch(Exception e){
			lblError.setText(e.getMessage());
		}
		
	}
	
	public void backToMenu(){
		try{
			tfTitulo.clear();
			classificacaoBox.setValue("L");
			generoBox.setValue("Ação");
			tfDuracao.clear();
			tfPesquisa.clear();
			ScreenManager.getInstance().getMenu();
			System.out.println("entrou aqui");
		}
		catch(Exception e){
			lblError.setText("editado");;
		}
	}
	
	public void sair(){
		try{
			tfTitulo.clear();
			classificacaoBox.setValue("L");
			generoBox.setValue("Ação");;
			tfDuracao.clear();
			tfPesquisa.clear();
			ScreenManager.getInstance().getTelaLogin();
			System.out.println("entrou aqui");
		}
		catch(Exception e){
			lblError.setText("Editado");;
		}
	}
}
