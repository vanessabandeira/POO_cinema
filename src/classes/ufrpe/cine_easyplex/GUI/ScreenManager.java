package classes.ufrpe.cine_easyplex.GUI;

import java.net.URL;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;

public class ScreenManager {
	
	BorderPane paneLogin;
	BorderPane paneMenu;
	BorderPane paneOpcoes;
	BorderPane border;
	
	public static ScreenManager instancia;
	
	public static synchronized ScreenManager getInstance(){
		if(instancia == null){
			instancia = new ScreenManager();
		}
		return instancia;
	}
	
	private ScreenManager(){
		try{
			URL paneMenuUrl = getClass().getResource("Menu.fxml"); 
			this.paneMenu = FXMLLoader.load( paneMenuUrl );     
			URL paneLoginUrl = getClass().getResource("TelaLogin.fxml"); 
			this.paneLogin = FXMLLoader.load( paneLoginUrl );   
			URL paneOpcoesUrl = getClass().getResource("Opcoes.fxml"); 
			this.paneOpcoes = FXMLLoader.load( paneOpcoesUrl );   
			this.border = Main.getRoot();
		}
		catch(Exception e){
		}
	}
	
	public void getTelaLogin(){
		border.setCenter(this.paneLogin);
	}
	
	public void getMenu(){
		border.setCenter(this.paneMenu);
	}
	
	public void getOpcoes(){
		border.setCenter(this.paneOpcoes);
	}
}
