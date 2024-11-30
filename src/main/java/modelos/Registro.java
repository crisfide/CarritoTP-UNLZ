package modelos;

import java.util.List;

public class Registro {
	private int id;
	private int usuarioId;
	private List<ElementoCarrito> carrito;
	private double total;
	
	public Registro(int usuario, List<ElementoCarrito> carrito, double total) {
		super();
		this.usuarioId = usuario;
		this.carrito = carrito;
		this.total = total;
	}

	public Registro(int id, int usuario, List<ElementoCarrito> carrito, double total) {
		super();
		this.id = id;
		this.usuarioId = usuario;
		this.carrito = carrito;
		this.total = total;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(int usuario) {
		this.usuarioId = usuario;
	}

	public List<ElementoCarrito> getCarrito() {
		return carrito;
	}

	public void setCarrito(List<ElementoCarrito> carrito) {
		this.carrito = carrito;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	
	
	

}
