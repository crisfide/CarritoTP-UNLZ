package repositories.interfaces;

import java.util.List;
import modelos.Articulo;
import modelos.Registro;
import modelos.Usuario;

public interface RegistroRepo {
	public List<Registro> getAll();
	public List<Registro> getAllUser(Usuario u);
	
	public Registro findById(int id);

	public void insert(Registro r);
}
