package br.com.ufrpe.cine_easyplex.gui;

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
	
	public void adicionarSala(){
		try{
			ScreenManager.getInstance().getAdicionarSala();
			System.out.println("entrou aqui");
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	public void editarSala(){
		try{
			ScreenManager.getInstance().getEditarSala();
			System.out.println("entrou aqui");
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	public void adicionarConta(){
		try{
			ScreenManager.getInstance().getAdicionarConta();
			System.out.println("entrou aqui");
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	public void removerConta(){
		try{
			ScreenManager.getInstance().getRemoverConta();
			System.out.println("entrou aqui");
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	public void adicionarSessao(){
		try{
			ScreenManager.getInstance().getAdicionarSessao();
			System.out.println("entrou aqui");
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	public void removerSessao(){
		try{
			ScreenManager.getInstance().getRemoverSessao();;
			System.out.println("entrou aqui");
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	public void arrecadacao(){
		try{
			ScreenManager.getInstance().getArrecadacao();
			System.out.println("entrou aqui");
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	public void removerSala(){
		try{
			ScreenManager.getInstance().getRemoverSala();;
			System.out.println("entrou aqui");
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}
