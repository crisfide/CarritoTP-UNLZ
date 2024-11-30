package factory;
import repositories.ArticuloRepoSingleton;
import repositories.CarritoRepoSingleton;
import repositories.RegistroRepoSingleton;
import repositories.UsuarioRepoSingleton;
import repositories.interfaces.ArticuloRepo;
import repositories.interfaces.CarritoRepo;
import repositories.interfaces.RegistroRepo;
import repositories.interfaces.UsuarioRepo;

public class RepoFactory {
	
	public ArticuloRepo getArticuloRepo(){
		
		return ArticuloRepoSingleton.getInstance();
	}
    public UsuarioRepo getUsuarioRepo(){
		
		return UsuarioRepoSingleton.getInstance();
	}
    public CarritoRepo getCarrito(){
		
		return CarritoRepoSingleton.getInstance();
	}
    public RegistroRepo getRegistroRepo() {
    	return RegistroRepoSingleton.getInstance();
    }
	

}
