package classes.ufrpe.cine_easyplex.GUI;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class TelaLoginController {
	
	@FXML TextField tfLogin;
	@FXML PasswordField tfSenha;
	private Fachada fachada = Fachada.getInstancia();
	
	public void Login(){
		String login = this.tfLogin.getText();
		String senha = this.tfSenha.getText();
		if(this.fachada.getContas().logar(login, senha)){
			System.out.println("Logou!");
		}
		else{
			System.out.println("Hj n, amigão");
		}
	}
}
