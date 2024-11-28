package modelos;

import java.util.ArrayList;
import java.util.List;

import javax.management.relation.InvalidRelationTypeException;

public class Proyecto {

	
	
	
	
	private int liderCodigo;	
	private int codigo;	
	private double presupuesto;
	private double total;
	
	
	//Relacional; 
	
	private List<ProyectoDetalle> detalle;
	
	
	
	public Proyecto() {
		this.detalle = new ArrayList<ProyectoDetalle>();
	}


	public Proyecto(int liderCodigo, double presupuesto, double total) {

		this();
		this.liderCodigo = liderCodigo;
		this.presupuesto = presupuesto;
		this.total = total;
	}


	public void addDetalle(int articuloCodigo, String tarea, double precio) {
		this.detalle.add(new ProyectoDetalle(articuloCodigo,tarea,precio)); 
	}
	

	public int getLiderCodigo() {
		return liderCodigo;
	}


	public void setLiderCodigo(int liderCodigo) {
		this.liderCodigo = liderCodigo;
	}


	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public double getPresupuesto() {
		return presupuesto;
	}


	public void setPresupuesto(double presupuesto) {
		this.presupuesto = presupuesto;
	}


	public double getTotal() {
		return total;
	}


	public void setTotal(double total) {
		this.total = total;
	}


	public List<ProyectoDetalle> getDetalle() {
		return detalle;
	}


	@Override
	public String toString() {
		return "Proyecto liderCodigo=" + liderCodigo + ", codigo=" + codigo + ", presupuesto=" + presupuesto
				+ ", total=" + total ;
	}
	
	
	
	
	
	
}
