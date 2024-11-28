package modelos;

public class ProyectoDetalle {

	private int codigo;
	private int proyectoId;
	private int articuloCodigo;
	private String tarea;
	private double precio;
	
	
	




	public ProyectoDetalle(int articuloCodigo, String tarea, double precio) {
		this.articuloCodigo = articuloCodigo;
		this.tarea = tarea;
		this.precio = precio;
	}





	public ProyectoDetalle() {
		
	}





	public double getPrecio() {
		return precio;
	}





	public void setPrecio(double precio) {
		this.precio = precio;
	}





	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getProyectoId() {
		return proyectoId;
	}
	public void setProyectoId(int proyectoId) {
		this.proyectoId = proyectoId;
	}
	public int getArticuloCodigo() {
		return articuloCodigo;
	}
	public void setArticuloCodigo(int articuloCodigo) {
		this.articuloCodigo = articuloCodigo;
	}
	public String getTarea() {
		return tarea;
	}
	public void setTarea(String tarea) {
		this.tarea = tarea;
	}





	@Override
	public String toString() {
		return "ProyectoDetalle [codigo=" + codigo + ", proyectoId=" + proyectoId + ", articuloCodigo=" + articuloCodigo
				+ ", tarea=" + tarea + ", precio=" + precio + "]";
	}
	
	
	
	
	
}
