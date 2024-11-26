package repositories.interfaces;

import java.util.List;

import modelos.Usuario;

public interface UsuarioRepo {
	
	public List<Usuario> getAll();
	public Usuario findById(int id);
	public Usuario findByNombre(String nombre);
	public void insert(Usuario usu);

}
