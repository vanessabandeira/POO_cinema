package classes.ufrpe.cine_easyplex.GUI;

import classes.ufrpe.cine_easyplex.beans.Filme;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AdicionarFilmesController {
	@FXML TextField tfTitulo, tfGenero, tfClassificacao, tfDuracao;
	@FXML Label lblError;
	
	public void adicionar(){
		try{
			Filme filme = new Filme();
			filme.setTitulo(tfTitulo.getText());
			filme.setDuracao(Integer.valueOf(tfDuracao.getText()));
			filme.setClassificacao(Integer.valueOf(tfClassificacao.getText()));
			filme.setGenero(tfGenero.getText());
			Fachada.getInstancia().getFilmes().adicionarFilme(filme);
			lblError.setText("Adicionado com sucesso!");
			tfTitulo.clear();
			tfGenero.clear();
			tfClassificacao.clear();
			tfDuracao.clear();
			
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
