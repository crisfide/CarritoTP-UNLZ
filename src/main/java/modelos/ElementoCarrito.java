package modelos;

public class ElementoCarrito {
	private int cantidad;
	private Articulo articulo;
	
	public ElementoCarrito(int cantidad, Articulo articulo) {
		super();
		this.cantidad = cantidad;
		this.articulo = articulo;
	}
	
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public Articulo getArticulo() {
		return articulo;
	}
	public void setArticulo(Articulo articulo) {
		this.articulo = articulo;
	}
	@Override
	public String toString() {
		return "ElementoCarrito [cantidad=" + cantidad + ", articulo=" + articulo + "]";
	}
	
	
}
