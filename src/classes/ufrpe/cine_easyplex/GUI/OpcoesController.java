package classes.ufrpe.cine_easyplex.GUI;

import java.net.URL;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;

public class OpcoesController {
	
	
	public void backToMenu(){
		try{
			ScreenManager.getInstance().getMenu();
			System.out.println("entrou aqui");
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
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
	
	public void adicionarFilme(){
		try{
			ScreenManager.getInstance().getAdicionarFilme();;
			System.out.println("entrou aqui");
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	public void removerFilme(){
		try{
			ScreenManager.getInstance().getRemoverFilme();
			System.out.println("sucesso");
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		
	}
	
	public void editarFilme(){
		try{
			ScreenManager.getInstance().getEditarFilme();;
			System.out.println("entrou aqui");
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}
