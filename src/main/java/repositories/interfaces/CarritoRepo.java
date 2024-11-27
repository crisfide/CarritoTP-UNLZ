package repositories.interfaces;

import java.util.List;
import modelos.Articulo;
import modelos.ElementoCarrito;

public interface CarritoRepo {
	public List<ElementoCarrito> getAll();
	//public ElementoCarrito findById(int id);

	public void agregar(Articulo art, int cantidad) throws Exception;
	public void quitar(Articulo art, int cantidad) throws Exception;
}
