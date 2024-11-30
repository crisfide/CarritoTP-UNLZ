package repositories;

import java.util.ArrayList;
import java.util.List;

import modelos.Articulo;
import repositories.interfaces.ArticuloRepo;

public class ArticuloRepoSingleton implements ArticuloRepo {
	
	public static ArticuloRepoSingleton singleton;
	
	
	public static ArticuloRepoSingleton getInstance() {
		if(singleton==null) {
			singleton=new ArticuloRepoSingleton();
		}
		return singleton;
	}

	private List<Articulo> listaArticulos;
	
	private ArticuloRepoSingleton() {
        this.listaArticulos = new ArrayList<>();

        this.insert(new Articulo(1, "Teclado", 25.99, 50));
        this.insert(new Articulo(2, "Mouse", 15.49, 75));
        this.insert(new Articulo(3, "Monitor", 199.99, 30));
        this.insert(new Articulo(4, "Memoria RAM 8GB", 45.99, 20));
        this.insert(new Articulo(5, "Disco Duro 1TB", 89.99, 15));
        this.insert(new Articulo(6, "Placa Madre", 120.00, 10));
        this.insert(new Articulo(7, "Fuente de Poder 500W", 65.99, 25));
        this.insert(new Articulo(8, "Procesador", 299.99, 5));
        this.insert(new Articulo(9, "Cámara Web", 49.99, 40));
        this.insert(new Articulo(10, "Auriculares", 35.49, 60));

	}

	@Override
	public List<Articulo> getAll() {
		return new ArrayList<Articulo>(listaArticulos);
	}

	@Override
	public Articulo findById(int id) {
		return this.listaArticulos.stream()
				.filter(e-> e.getCodigo() == id)
				.findFirst()
				.orElse(null); 
	}

	@Override
	public void insert(Articulo art) {

		int ultimaId = listaArticulos.stream()
				.map(Articulo::getCodigo)
				.max(Integer::compare)
				.orElse(0);
		
		art.setCodigo(ultimaId + 1);
		
		listaArticulos.add(art);		
		
	}

	@Override
	public void update(Articulo art) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		this.listaArticulos.removeIf(e-> e.getCodigo()==id);
		
	}
	
	public boolean disminuirStock(int cantidad, Articulo art) {
        if (cantidad > art.getStock()) {
            return false;
        }   
		   art.setStock(art.getStock()-cantidad) ;
		   return true;
}



}
	
	

