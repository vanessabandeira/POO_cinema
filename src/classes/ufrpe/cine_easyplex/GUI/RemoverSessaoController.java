package classes.ufrpe.cine_easyplex.GUI;

import java.util.Optional;

import classes.ufrpe.cine_easyplex.Exceptions.ValorInvalidoException;
import classes.ufrpe.cine_easyplex.beans.Filme;
import classes.ufrpe.cine_easyplex.beans.Sessao;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;

public class RemoverSessaoController {
	@FXML
	private TableView<Sessao> tableView;
	@FXML
	private TableColumn<Sessao,Integer> listaSala;
	@FXML
	private TableColumn<Sessao, String> listaTitulo;
	@FXML
	private TableColumn<Sessao, String> listaHinicio;
	@FXML
	private TableColumn<Sessao, String> listaHfim;
	
	private Sessao sessaoselecionada;
	Fachada fachada = Fachada.getInstancia();
	@FXML Label lblError;

	public void preencherTabela(){
		listaSala.setCellValueFactory(new PropertyValueFactory<Sessao, Integer>("Sala"));
		listaTitulo.setCellValueFactory(new PropertyValueFactory<Sessao, String>("Titulo"));
		listaHinicio.setCellValueFactory(new PropertyValueFactory<Sessao, String>("Hinicio"));
		listaHfim.setCellValueFactory(new PropertyValueFactory<Sessao, String>("Hfim"));
		
        tableView.setItems(FXCollections.observableArrayList(Fachada.getInstancia().getSessoes().getRepositorioSessao().listar()));
        tableView.refresh();
	}
	
	public void remover() throws ValorInvalidoException {
		sessaoselecionada = tableView.getSelectionModel().getSelectedItem();
		if (sessaoselecionada != null) {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("CineEasyPlex");
			alert.setHeaderText("Deseja remover o sessão " + sessaoselecionada.getExibicao() + " às "+ sessaoselecionada.getHinicio() +" na sala" + sessaoselecionada.getHall()+" ?");
			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK) {
				for(int i = 0; i < fachada.getSessoes().getRepositorioSessao().listar().size(); i++){
					if(fachada.getSessoes().getRepositorioSessao().listar().get(i).equals(sessaoselecionada)){
						fachada.getSessoes().removerSessao(fachada.getSessoes().getRepositorioSessao().listar().get(i));
					}
				}
				Fachada.getInstancia().removerSessao(sessaoselecionada);
				preencherTabela();
				
			}
		}
	}
	public void backToMenu(){
		try{
			ScreenManager.getInstance().getMenu();
			System.out.println("sucesso");
		}
		catch(Exception e){
			lblError.setText("removido");;
		}
	}
	
	public void sair(){
		try{
			ScreenManager.getInstance().getTelaLogin();
			System.out.println("sucesso");
		}
		catch(Exception e){
			lblError.setText("removido");;
		}
	}
}