package factory;
import repositories.ArticuloRepoSingleton;
import repositories.UsuarioRepoSingleton;
import repositories.interfaces.ArticuloRepo;
import repositories.interfaces.UsuarioRepo;

public class RepoFactory {
	
	public ArticuloRepo getArticuloRepo(){
		
		return ArticuloRepoSingleton.getInstance();
	}
    public UsuarioRepo getUsuarioRepo(){
		
		return UsuarioRepoSingleton.getInstance();
	}
	

}
