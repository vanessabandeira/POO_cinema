package classes.ufrpe.cine_easyplex.GUI;

import java.net.URL;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;

public class OpcoesController {
	
	
	public void backToMenu(){
		try{
			URL paneUrl = getClass().getResource("Menu.fxml"); 
			BorderPane pane = FXMLLoader.load( paneUrl );     
			BorderPane border = Main.getRoot(); 
			border.setCenter(pane);
			System.out.println("entrou aqui");
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	public void sair(){
		try{
			URL paneUrl = getClass().getResource("TelaLogin.fxml"); 
			BorderPane pane = FXMLLoader.load( paneUrl );     
			BorderPane border = Main.getRoot(); 
			border.setCenter(pane);
			System.out.println("entrou aqui");
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}
