package classes.ufrpe.cine_easyplex.GUI;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class TelaLoginController {
	
	@FXML TextField tfLogin;
	@FXML PasswordField tfSenha;
	@FXML Label lblError;
	private Fachada fachada = Fachada.getInstancia();
	
	public void Login(){
		String login = this.tfLogin.getText();
		String senha = this.tfSenha.getText();
		try{
			this.fachada.getContas().logar(login, senha);
			
			ScreenManager.getInstance().getMenu(); 

		}
		catch(Exception e){
			this.lblError.setText(e.getMessage());
		}
	}
}
