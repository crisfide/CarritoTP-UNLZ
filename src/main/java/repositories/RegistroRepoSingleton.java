package repositories;

import java.util.ArrayList;
import java.util.List;

import modelos.Registro;
import modelos.Usuario;
import repositories.interfaces.RegistroRepo;

public class RegistroRepoSingleton implements RegistroRepo{

	public static RegistroRepoSingleton singleton;
	
	
	public static RegistroRepoSingleton getInstance() {
		if(singleton==null) {
			singleton=new RegistroRepoSingleton();
		}
		return singleton;
	}
	
	private List<Registro> lista;


	private RegistroRepoSingleton() {
        this.lista = new ArrayList<>();
	}
	
	@Override
	public List<Registro> getAll() {
		return new ArrayList<Registro>(lista);
	}

	@Override
	public List<Registro> getAllUser(Usuario u) {
		return this.getAll().stream()
				.filter(e-> e.getUsuarioId() == u.getId())
				.toList();
	}

	@Override
	public Registro findById(int id) {
		return this.lista.stream()
				.filter(e-> e.getId() == id)
				.findFirst()
				.orElse(null); 
	}

	@Override
	public void insert(Registro r) {
		int ultimaId = lista.stream()
				.map(Registro::getId)
				.max(Integer::compare)
				.orElse(0);
		
		r.setId(ultimaId + 1);
		
		lista.add(r);		
		
	}
	

}
