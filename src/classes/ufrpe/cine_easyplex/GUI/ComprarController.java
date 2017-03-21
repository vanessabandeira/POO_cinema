package classes.ufrpe.cine_easyplex.GUI;

import java.util.Date;

import classes.ufrpe.cine_easyplex.beans.Filme;
import classes.ufrpe.cine_easyplex.beans.Sessao;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class ComprarController {
	@FXML private Pane comprar;
	@FXML private Label labelTitulo;
	@FXML private Label labelClassificacao;
	@FXML private Label labelGenero;
	@FXML private ChoiceBox boxSessao;
	@FXML private GridPane gridCadeiras;
	@FXML private Button cancelar, confirmar;
	@FXML private Label labelErro;
	private Filme filme;
	
	
	public void setFilme(Filme filmeselecionado){
		this.filme = filmeselecionado;
		labelTitulo.setText(this.filme.getTitulo());
		labelClassificacao.setText(this.filme.getClassificacao());
		labelGenero.setText(this.filme.getGenero());
		boxSessao.setItems(FXCollections.observableArrayList(Fachada.getInstancia().getSessoes().buscarPorFilme(filmeselecionado)));
	}
	
	public void atualizarSessao(){
		System.out.println(boxSessao.getSelectionModel().getSelectedItem());
		if(boxSessao.getSelectionModel().getSelectedItem() instanceof Sessao){
			for (int r = 0; r < 10; r++) {
		        for (int c = 0; c < 20; c++) {
		            int number = 20 * r + c;
		            Button button = new Button();
		            button.setBackground(new Background(new BackgroundFill(Color.BLUE, null, null)));
		            button.setMinHeight(20);
		            button.setMinWidth(20);
		            gridCadeiras.add(button, c, r);
		        }
		    }
			labelErro.setText("");
		}else{
			for (int r = 0; r < 10; r++) {
		        for (int c = 0; c < 20; c++) {
		            int number = 20 * r + c;
		            Button button = new Button();
		            button.setBackground(new Background(new BackgroundFill(Color.GRAY, null, null)));
		            button.setMinHeight(20);
		            button.setMinWidth(20);
		            button.setDisable(true);
		            gridCadeiras.add(button, c, r);
		        }
		    }
			if(boxSessao.getItems().size() == 0){
				labelErro.setText("Não há sessões disponíveis para o filme");
			}else{
				labelErro.setText("Você não selecionou uma sessão disponível.");
			}
			
		}
	}
	
	public void menuPrincipal(){
		ScreenManager.getInstance().getMenu();
	}
}
