package repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import modelos.Articulo;
import modelos.ElementoCarrito;
import repositories.interfaces.ArticuloRepo;
import repositories.interfaces.CarritoRepo;

public class CarritoRepoSingleton implements CarritoRepo {
	
	public static CarritoRepoSingleton singleton;
	
	
	public static CarritoRepoSingleton getInstance() {
		if(singleton==null) {
			singleton=new CarritoRepoSingleton();
		}
		return singleton;
	}

	private List<ElementoCarrito> lista;
	
	private CarritoRepoSingleton() {
        this.lista= new ArrayList<>();
	}

	@Override
	public List<ElementoCarrito> getAll() {
		return new ArrayList<ElementoCarrito>(lista);
	}



	@Override
	public void agregar(Articulo art, int cantidad) {
		ElementoCarrito existente = this.lista.stream()
				.filter(e -> e.getArticulo().getCodigo() == art.getCodigo())
				.findFirst() // solo hay uno
				.orElse(null);
                
        if(existente==null) {
        	this.lista.add(new ElementoCarrito(cantidad, art));        	
        }else {
        	existente.setCantidad(existente.getCantidad()+cantidad);
        }
        
	
	}


	@Override
	public void quitar(Articulo art, int cantidad) throws Exception {
		Optional<ElementoCarrito> optionalExistente = this.lista.stream()
			    .filter(e -> e.getArticulo().getCodigo() == art.getCodigo())
			    .findFirst();

			if (optionalExistente.isPresent()) {
			    ElementoCarrito existente = optionalExistente.get();

			    if (existente.getCantidad() == 1) {
			        this.lista.remove(existente);
			    } else if (existente.getCantidad() > cantidad) {
			        existente.setCantidad(existente.getCantidad() - cantidad);
			    } else {
			        throw new Exception("Error: No se puede reducir más allá de la cantidad actual.");
			    }
			} else {
				throw new Exception("Error: El artículo no está en el carrito.");
			}

	}
	
	


	
	

}
