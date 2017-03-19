package classes.ufrpe.cine_easyplex.GUI;

import classes.ufrpe.cine_easyplex.Exceptions.SenhasDiferentesException;
import classes.ufrpe.cine_easyplex.beans.Conta;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

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
			lblError.setText(e.getMessage());
		}
		catch(Exception e){
			lblError.setText("Os valores de login e senha não são válidos");
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
