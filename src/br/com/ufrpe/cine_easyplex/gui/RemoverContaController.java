package br.com.ufrpe.cine_easyplex.gui;

import br.com.ufrpe.cine_easyplex.negocio.beans.Conta;
import br.com.ufrpe.cine_easyplex.utils.exceptions.SenhasDiferentesException;
import br.com.ufrpe.cine_easyplex.utils.exceptions.ValorInvalidoException;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class RemoverContaController {
	
	@FXML TextField tfLogin;
	@FXML PasswordField tfSenha, tfRepetirSenha;
	@FXML Label lblError;
	
	public void remover(){
		try{
			Conta conta = new Conta();
			if(tfSenha.getText().equals(tfRepetirSenha.getText())){
				conta.setLogin(tfLogin.getText());
				conta.setSenha(tfSenha.getText());
				Fachada.getInstancia().getContas().logar(conta.getLogin(), conta.getSenha());
				Fachada.getInstancia().getContas().removerConta(conta);
				tfLogin.clear();
				tfSenha.clear();
				tfRepetirSenha.clear();
				lblError.setText("");
			}
			else throw new SenhasDiferentesException();
		}
		catch(SenhasDiferentesException e){
			lblError.setText(e.getMessage());
		}
		catch(ValorInvalidoException e){
			lblError.setText(e.getMessage());
		}
		catch(Exception e){
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("CineEasyPlex");
			alert.setHeaderText("NOTAÇÃO INVÁLIDA");
			alert.setContentText(" Digite novamente o login e senha");
			alert.showAndWait();
		}
		
	}
	
	public void backToMenu(){
		try{
			tfLogin.clear();
			tfSenha.clear();
			tfRepetirSenha.clear();
			lblError.setText("");
			ScreenManager.getInstance().getMenu();
			System.out.println("entrou aqui");
		}
		catch(Exception e){
			lblError.setText(e.getMessage());;
		}
	}
	
	public void sair(){
		try{
			tfLogin.clear();
			tfSenha.clear();
			tfRepetirSenha.clear();
			lblError.setText("");
			ScreenManager.getInstance().getTelaLogin();
			System.out.println("entrou aqui");
		}
		catch(Exception e){
			lblError.setText(e.getMessage());;
		}
	}

}
