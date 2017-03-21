package classes.ufrpe.cine_easyplex.GUI;

import classes.ufrpe.cine_easyplex.Exceptions.SenhasDiferentesException;
import classes.ufrpe.cine_easyplex.beans.Conta;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class AdicionarContaController {
	
	@FXML TextField tfLogin;
	@FXML PasswordField tfSenha, tfRepetirSenha;
	@FXML Label lblError;
	
	public void adicionar(){
		try{
			Conta conta = new Conta();
			if(tfSenha.getText().equals(tfRepetirSenha.getText())){
				conta.setLogin(tfLogin.getText());
				conta.setSenha(tfSenha.getText());
				Fachada.getInstancia().getContas().adicionarConta(conta);
				tfLogin.clear();
				tfSenha.clear();
				tfRepetirSenha.clear();
			}
			else throw new SenhasDiferentesException();
		}
		catch(SenhasDiferentesException e){
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("CineEasyPlex");
			alert.setHeaderText("INCORRETA");
			alert.setContentText("senhas não conferem");
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
			tfLogin.clear();
			tfSenha.clear();
			tfRepetirSenha.clear();
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
			ScreenManager.getInstance().getTelaLogin();
			System.out.println("entrou aqui");
		}
		catch(Exception e){
			lblError.setText(e.getMessage());;
		}
	}

}
