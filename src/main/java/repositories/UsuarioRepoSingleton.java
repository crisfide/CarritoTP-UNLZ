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
			 
		this.insert(new Usuario("Carlos", "1234","Empleado",1));
        this.insert(new Usuario("Manuel", "1234","Cliente",2));
	
	}
		
	public List<Usuario> getAll() {
		return new ArrayList<Usuario>(listaUsuarios);
	}
	
 	public void insert(Usuario usu) {
		listaUsuarios.add(usu);		
		
	}

	@Override
	public Usuario findById(int id) {
		return this.listaUsuarios.stream()
		           .filter(e-> e.getId() == id)
		           .findFirst()
		           .orElse(null);		
	}
	@Override
	public Usuario findByNombre(String nombre) {
		return this.listaUsuarios.stream()
				.filter(e-> e.getNombre()== nombre)
				.findFirst()
				.orElse(null);
	
	}
	
}

