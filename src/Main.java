import classes.ufrpe.cine_easyplex.beans.Filme;
import classes.ufrpe.cine_easyplex.negocio.CadastroFilmes;

public class Main {

	public static void main(String[] args) {
		
		CadastroFilmes controladorFilmes = CadastroFilmes.getInstance();
		
		Filme esquadrao = new Filme("Esquadrão Suicida",14,"ação",120,0);
		controladorFilmes.adicionarFilme(esquadrao);
		Filme bvs = new Filme("Batam v Superman",14,"ação",150,0);
		controladorFilmes.adicionarFilme(bvs);
		
//		for(Filme titulo : controladorFilmes.getRepositorioFilmes().getFilmes()){
//			System.out.println(titulo);
//			System.out.println(controladorFilmes.getRepositorioFilmes().getFilmes().size());
//		}
		
		controladorFilmes.adicionarFilme(bvs);
		
		
		

	}

}
