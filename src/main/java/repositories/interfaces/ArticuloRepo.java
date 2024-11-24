package repositories.interfaces;

import java.util.List;
import modelos.Articulo;

public interface ArticuloRepo {
	public List<Articulo> getAll();
	public Articulo findById(int id);

	public static void insert(Articulo art) {
		// TODO Auto-generated method stub
		
	}
	public void update(Articulo art);
	public void delete(int id);
}
