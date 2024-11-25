package repositories.interfaces;

import java.util.List;

import modelos.Usuario;

public interface UsuarioRepo {
	
	public List<Usuario> getAll();
	public void insert(Usuario usu);

}
