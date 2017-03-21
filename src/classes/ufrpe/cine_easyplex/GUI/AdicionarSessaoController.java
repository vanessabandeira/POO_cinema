package classes.ufrpe.cine_easyplex.GUI;

import java.util.Date;

import classes.ufrpe.cine_easyplex.beans.Sessao;

public class AdicionarSessaoController {
	public void adicionar(){
		try{
			Date data = new Date();
			Sessao sessao = new Sessao(,,data);
		}
		catch{
			
		}
	}

	public void backToMenu() {
		try {
			ScreenManager.getInstance().getMenu();
			System.out.println("entrou aqui");
		} catch (Exception e) {
			lblError.setText(e.getMessage());
		}
	}

	public void sair() {
		try {
			ScreenManager.getInstance().getTelaLogin();
			System.out.println("entrou aqui");
		} catch (Exception e) {
			lblError.setText(e.getMessage());
		}
	}
}
