package classes.ufrpe.cine_easyplex.GUI;

import java.text.SimpleDateFormat;
import java.util.Date;

import classes.ufrpe.cine_easyplex.beans.Filme;
import classes.ufrpe.cine_easyplex.beans.Sala;
import classes.ufrpe.cine_easyplex.beans.Sessao;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AdicionarSessaoController {
	@FXML ChoiceBox boxFilme;
	@FXML ChoiceBox boxSala;
	@FXML TextField caixaHora;
	@FXML TextField caixaMinutos;
	@FXML TextField caixaValor;
	@FXML Label lblError;
	
	Filme filmeselecionado;
	Sala salaselecionada;
	float valor;
	
	public void preencherTabela(){
		boxFilme.setItems(FXCollections.observableArrayList(Fachada.getInstancia().getFilmes().getRepositorioFilmes().listar()));
		boxSala.setItems(FXCollections.observableArrayList(Fachada.getInstancia().getSalas().getRepositorioSalas().listar()));
	}
	
	public void adicionar(){
		try{
			filmeselecionado = (Filme) boxFilme.getSelectionModel().getSelectedItem();
			salaselecionada = (Sala) boxSala.getSelectionModel().getSelectedItem();
			Date data = new Date();
			data.setHours(Integer.parseInt(caixaHora.getText()));
			data.setMinutes(Integer.parseInt(caixaMinutos.getText()));
			valor = Float.parseFloat(caixaValor.getText());
			
			Sessao sessao = new Sessao(this.filmeselecionado, this.salaselecionada, data, valor);
			try{
				Fachada.getInstancia().getSessoes().adicionarSessao(sessao);
				lblError.setText("Sessão Cadastrada.");
			}catch(Exception e){
				lblError.setText("Ocorreu um erro.");
			}
			
		}catch(Exception e){
			lblError.setText("Ocorreu um erro.");
		}
	}
	
	public void backToMenu(){
		ScreenManager.getInstance().getMenu();
	}
	
	public void sair(){
		try{
			ScreenManager.getInstance().getTelaLogin();
			System.out.println("entrou aqui");
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		
	}

}
