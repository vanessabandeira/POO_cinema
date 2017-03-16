package classes.ufrpe.cine_easyplex.GUI;

import classes.ufrpe.cine_easyplex.beans.Filme;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class EditarFilmeController {
	@FXML TextField tfPesquisa, tfTitulo, tfGenero, tfClassificacao, tfDuracao;
	@FXML Label lblError;
	private Filme filme;
	
	public void pesquisar(){
		this.lblError.setText("");
		this.filme = Fachada.getInstancia().getFilmes().buscarFilme(tfPesquisa.getText());
		if(filme == null){
			this.lblError.setText("O filme não existe");
		}
		else{
			tfTitulo.setText(this.filme.getTitulo());
			tfGenero.setText(this.filme.getGenero());
			tfClassificacao.setText(""+(this.filme.getClassificacao()));
			tfDuracao.setText(""+this.filme.getDuracao());
		}
		
	}
	
	public void comprar(){
		
	}
	
	public void concluir(){
		try{
			filme.setTitulo(tfTitulo.getText());
			filme.setDuracao(Integer.valueOf(tfDuracao.getText()));
			filme.setClassificacao(Integer.valueOf(tfClassificacao.getText()));
			filme.setGenero(tfGenero.getText());
			Fachada.getInstancia().getFilmes().editarFilme(filme);
			lblError.setText("Editado com sucesso!");
			tfTitulo.clear();
			tfGenero.clear();
			tfClassificacao.clear();
			tfDuracao.clear();
			tfPesquisa.clear();
			
		}
		catch(NumberFormatException e){
			lblError.setText("Valores de duração ou classificação inválido(s)");
		}
		catch(Exception e){
			lblError.setText(e.getMessage());
		}
		
	}
	
	public void backToMenu(){
		try{
			tfTitulo.clear();
			tfGenero.clear();
			tfClassificacao.clear();
			tfDuracao.clear();
			tfPesquisa.clear();
			ScreenManager.getInstance().getMenu();
			System.out.println("entrou aqui");
		}
		catch(Exception e){
			lblError.setText(e.getMessage());;
		}
	}
	
	public void sair(){
		try{
			tfTitulo.clear();
			tfGenero.clear();
			tfClassificacao.clear();
			tfDuracao.clear();
			tfPesquisa.clear();
			ScreenManager.getInstance().getTelaLogin();
			System.out.println("entrou aqui");
		}
		catch(Exception e){
			lblError.setText(e.getMessage());;
		}
	}
}
