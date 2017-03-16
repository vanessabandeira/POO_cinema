package classes.ufrpe.cine_easyplex.GUI;

import java.net.URL;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;

public class ScreenManager {
	
	BorderPane paneLogin;
	BorderPane paneMenu;
	BorderPane paneOpcoes;
	BorderPane border;
	BorderPane paneAdicionarFilme;
	
	FXMLLoader filmes;
	
	public static ScreenManager instancia;
	
	public static synchronized ScreenManager getInstance(){
		if(instancia == null){
			instancia = new ScreenManager();
		}
		return instancia;
	}
	
	private ScreenManager(){
		try{
			
			filmes = new FXMLLoader(this.getClass().getResource("classes/ufrpe/cine_easyplex/FXML/Menu.fxml"));
			this.paneMenu = filmes.load();     
			URL paneLoginUrl = getClass().getResource("classes/ufrpe/cine_easyplex/FXML/TelaLogin.fxml"); 
			this.paneLogin = FXMLLoader.load( paneLoginUrl );   
			URL paneOpcoesUrl = getClass().getResource("classes/ufrpe/cine_easyplex/FXML/Opcoes.fxml"); 
			this.paneOpcoes = FXMLLoader.load( paneOpcoesUrl ); 
			this.paneAdicionarFilme = FXMLLoader.load(getClass().getResource("classes/ufrpe/cine_easyplex/FXML/AdicionarFilme.fxml"));
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
		MenuController controlador = this.getFilmes().getController();
		controlador.preencherTabela();
	}
	
	public void getOpcoes(){
		border.setCenter(this.paneOpcoes);
	}
	
	public FXMLLoader getFilmes(){
		return this.filmes;
	}
	
	public void getAdicionarFilme(){
		border.setCenter(this.paneAdicionarFilme);
	}
}
