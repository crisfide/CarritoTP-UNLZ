package repositories;

import java.util.ArrayList;
import java.util.List;


import modelos.Usuario;
import repositories.interfaces.UsuarioRepo;

public class UsuarioRepoSingleton implements UsuarioRepo {
	
	public static UsuarioRepoSingleton singleton;
	
	public static UsuarioRepoSingleton getInstance() {
		
		if(singleton==null) {
			singleton=new UsuarioRepoSingleton();
		}
		return singleton;
	}
	
	private List<Usuario> listaUsuarios;
	
	private UsuarioRepoSingleton() {
		this.listaUsuarios = new ArrayList<>();
			 
		this.insert(new Usuario("Cliente", "1234"));
        this.insert(new Usuario("Empleado", "1234"));
	
	}
	
	
	public List<Usuario> getAll() {
		return new ArrayList<Usuario>(listaUsuarios);
	}
	
	public void insert(Usuario usu) {
		listaUsuarios.add(usu);		
		
	}
	
}

