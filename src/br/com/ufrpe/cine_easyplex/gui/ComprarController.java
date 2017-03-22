package br.com.ufrpe.cine_easyplex.gui;

import java.util.Date;

import br.com.ufrpe.cine_easyplex.negocio.beans.Filme;
import br.com.ufrpe.cine_easyplex.negocio.beans.Sessao;
import br.com.ufrpe.cine_easyplex.negocio.beans.Venda;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class ComprarController {
	@FXML
	private Pane comprar;
	@FXML
	private Label labelTitulo;
	@FXML
	private Label labelClassificacao;
	@FXML
	private Label labelGenero;
	@FXML
	private ChoiceBox boxSessao;
	@FXML
	private GridPane gridCadeiras;
	@FXML
	private Button cancelar, confirmar;
	@FXML
	private Label labelErro;
	@FXML
	private Label labelValor;
	@FXML
	private CheckBox checkMeia;
	private Filme filme;

	int cadeira = -1;
	float valor;
	Sessao sessaoselecionada;
//hello
	public void setFilme(Filme filmeselecionado) {
		this.filme = filmeselecionado;
		gridCadeiras.getChildren().clear();
		labelTitulo.setText(this.filme.getTitulo());
		labelClassificacao.setText(this.filme.getClassificacao());
		labelGenero.setText(this.filme.getGenero());
		boxSessao.setItems(FXCollections
				.observableArrayList(Fachada.getInstancia().getSessoes().buscarPorFilme(filmeselecionado)));
		atualizarSessao();
	}

	public void atualizarSessao() {
		sessaoselecionada = (Sessao) boxSessao.getSelectionModel().getSelectedItem();
		if (boxSessao.getSelectionModel().getSelectedItem() instanceof Sessao) {
			this.setValor();
			for (int r = 0; r < 10; r++) {
				for (int c = 0; c < 20; c++) {
					int number = 20 * r + c;
					if (sessaoselecionada.getCadeiraComprada(number)) {
						Button button = new Button();
						button.setBackground(new Background(new BackgroundFill(Color.RED, null, null)));
						button.setMinHeight(20);
						button.setMinWidth(20);
						button.setDisable(true);
						gridCadeiras.add(button, c, r);
					} else {
						Button button = new Button();
						button.setBackground(new Background(new BackgroundFill(Color.BLUE, null, null)));
						button.setMinHeight(20);
						button.setMinWidth(20);
						button.setId(String.valueOf(number));
						button.setOnAction(new EventHandler<ActionEvent>() {
							@Override
							public void handle(ActionEvent event) {
								if (boxSessao.getSelectionModel().getSelectedItem() instanceof Sessao) {
									cadeira = Integer.parseInt(button.getId());
									labelErro.setText("Você selecionou a cadeira: " + cadeira);
									labelValor.setText("R$" + valor);
									checkMeia.setDisable(false);
									setValor();
									confirmar.setDisable(false);
								}
							}
						});
						gridCadeiras.add(button, c, r);
					}
				}
			}
			labelErro.setText("");
		}
		if (boxSessao.getItems().size() == 0) {
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
			labelErro.setText("Não há sessões disponíveis para o filme");
			labelValor.setText("");
			checkMeia.setDisable(true);
			confirmar.setDisable(true);
		} else {
			labelErro.setText("Você não selecionou uma sessão disponível.");
			labelValor.setText("");
			checkMeia.setDisable(true);
			confirmar.setDisable(true);
		}

	}

	public void setValor() {
		if (checkMeia.isSelected()) {
			valor = sessaoselecionada.getValor() / 2;
		} else {
			valor = sessaoselecionada.getValor();
		}
	}

	public void comprar() {
		Sessao sessao = this.sessaoselecionada;

		sessao.setCadeira(cadeira);
		Fachada.getInstancia().getSessoes().getRepositorioSessao().alterar(sessao);
		
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("CineEasyPlex");
		alert.setHeaderText("COMPRA REALIZADA");
		alert.setContentText("Valor:R$" + valor + " Filme: " + filme.getTitulo());
		alert.showAndWait();
		atualizarSessao();
		menuPrincipal();
	}

	public void menuPrincipal() {
		ScreenManager.getInstance().getMenu();
	}
}
