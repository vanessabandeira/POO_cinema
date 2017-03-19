package classes.ufrpe.cine_easyplex.GUI;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;

public class ScreenManager {
	
	BorderPane paneLogin;
	BorderPane paneMenu;
	BorderPane paneOpcoes;
	BorderPane border;
	BorderPane paneAdicionarFilme;
	BorderPane paneAdicionarSala;
	BorderPane paneEditarFilme;
	BorderPane paneEditarSala;
	BorderPane paneRemoverFilme;
	BorderPane paneAdicionarConta;
	
	FXMLLoader menu, login, opcoes, adicionarFilme, editarFilme, adicionarSala, removerFilme, editarSala, adicionarConta;
	
	
	public static ScreenManager instancia;
	
	public static synchronized ScreenManager getInstance(){
		if(instancia == null){
			instancia = new ScreenManager();
		}
		return instancia;
	}
	
	private ScreenManager(){
		try{
			menu = new FXMLLoader(this.getClass().getResource("Menu.fxml"));
			this.paneMenu = menu.load();  
			login = new FXMLLoader(this.getClass().getResource("TelaLogin.fxml")); 
			this.paneLogin = login.load();  
			opcoes = new FXMLLoader(this.getClass().getResource("Opcoes.fxml"));
			this.paneOpcoes = opcoes.load(); 
			adicionarFilme = new FXMLLoader(this.getClass().getResource("AdicionarFilme.fxml"));
			this.paneAdicionarFilme = adicionarFilme.load();
			editarFilme = new FXMLLoader(this.getClass().getResource("EditarFilme.fxml"));
			this.paneEditarFilme = editarFilme.load();
			this.border = Main.getRoot();
			removerFilme = new FXMLLoader(this.getClass().getResource("RemoverFilme.fxml"));
			this.paneRemoverFilme = removerFilme.load();
			adicionarSala = new FXMLLoader(this.getClass().getResource("AdicionarSala.fxml"));
			this.paneAdicionarSala = adicionarSala.load();
			editarSala = new FXMLLoader(this.getClass().getResource("EditarSala.fxml"));
			this.paneEditarSala = editarSala.load();
			adicionarConta = new FXMLLoader(this.getClass().getResource("AdicionarConta.fxml"));
			this.paneAdicionarConta = adicionarConta.load();
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
		return this.menu;
	}
	
	public void getAdicionarFilme(){
		border.setCenter(this.paneAdicionarFilme);
	}
	public void getEditarFilme(){
		border.setCenter(this.paneEditarFilme);
	}
	public void getRemoverFilme(){
		border.setCenter(this.paneRemoverFilme);
		RemoverFilmesController controlador = this.removerFilme.getController();
		controlador.preencherTabela();
	}
	public void getAdicionarSala(){
		border.setCenter(paneAdicionarSala);
	}
	public void getEditarSala(){
		border.setCenter(paneEditarSala);
	}
	public void getAdicionarConta(){
		border.setCenter(paneAdicionarConta);
	}
}