package classes.ufrpe.cine_easyplex.GUI;

import classes.ufrpe.cine_easyplex.beans.Sala;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.TextField;

public class AdicionarSalaController {
	
	@FXML TextField tfID, tfCapacidade;
	@FXML CheckBox check3d, check4k, checkPrime; 
	@FXML Label lblError;
	
	public void adicionar(){
		try{
			
			Sala sala = new Sala();
			sala.setCapacidade(Integer.valueOf(tfCapacidade.getText()));
			sala.setIdentidade(Integer.valueOf(tfID.getText()));
			sala.setPrime(checkPrime.isSelected());
			sala.setV3d(check3d.isSelected());
			sala.setV4k(check4k.isSelected());
			Fachada.getInstancia().getSalas().adicionarSala(sala);
			tfID.clear();
			tfCapacidade.clear();
			check3d.setSelected(false);
			check4k.setSelected(false);
			checkPrime.setSelected(false);
			
		}
		catch(NumberFormatException e){
			lblError.setText("Por favor, utilize apenas números para ID e capacidade");
		}
		catch(Exception e){ 
			
			lblError.setText(e.getMessage());
		}
	}
	
	public void backToMenu(){
		try{
			ScreenManager.getInstance().getMenu();
			System.out.println("entrou aqui");
		}
		catch(Exception e){
			lblError.setText(e.getMessage());
		}
	}
	
	public void sair(){
		try{
			ScreenManager.getInstance().getTelaLogin();
			System.out.println("entrou aqui");
		}
		catch(Exception e){
			lblError.setText(e.getMessage());
		}
	}
}
