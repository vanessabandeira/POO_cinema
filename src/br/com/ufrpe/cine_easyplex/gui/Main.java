package br.com.ufrpe.cine_easyplex.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application{
	
	private static BorderPane root = new BorderPane();
	
	@Override
	public void start(Stage primaryStage) {
		try {
			this.root = FXMLLoader.load(getClass().getResource("/br/com/ufrpe/cine_easyplex/gui/TelaLogin.fxml"));
			Scene scene = new Scene(root,1080,720);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("Cine EasyPlex");
			primaryStage.setResizable(false);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
		Fachada sistema = Fachada.getInstancia();
	}
	
	public static BorderPane getRoot() { 
		return root; 
	} 


}
