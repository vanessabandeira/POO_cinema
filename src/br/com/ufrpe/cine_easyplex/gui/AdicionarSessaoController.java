package br.com.ufrpe.cine_easyplex.gui;

import java.util.Date;

import br.com.ufrpe.cine_easyplex.negocio.beans.Filme;
import br.com.ufrpe.cine_easyplex.negocio.beans.Sala;
import br.com.ufrpe.cine_easyplex.negocio.beans.Sessao;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("CineEasyPlex");
				alert.setHeaderText("Adicionar Sessão");
				alert.setContentText("Sessão adicionada!");
				alert.showAndWait();
				boxFilme.setValue("");
				boxSala.setValue("");
				caixaHora.clear();
				caixaMinutos.clear();
				caixaValor.clear();
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
