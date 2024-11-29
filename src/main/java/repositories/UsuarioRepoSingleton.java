package repositories;

import java.util.ArrayList;
import java.util.List;

import modelos.Articulo;
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
			 
		this.insert(new Usuario("Carlos", "1234","Empleado"));
        this.insert(new Usuario("Manuel", "1234","Cliente"));
        this.insert(new Usuario("Gabi", "1234","Cliente"));
        this.insert(new Usuario("Juank", "1234","Cliente"));
        this.insert(new Usuario("Cris", "1234","Cliente"));
	
	}
		
	public List<Usuario> getAll() {
		return new ArrayList<Usuario>(listaUsuarios);
	}
	
 	public void insert(Usuario usu) {
		int ultimaId = listaUsuarios.stream()
				.map(Usuario::getId)
				.max(Integer::compare)
				.orElse(0);		

		usu.setId(ultimaId + 1);
		
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
		        .filter(e -> e.getNombre().equalsIgnoreCase(nombre))
		        .findFirst()
		        .orElse(null);

	
	}
	
}

