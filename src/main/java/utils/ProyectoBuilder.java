package utils;

import modelos.Articulo;

public class ProyectoBuilder {
	
	private Articulo lider;
	private double presupuesto;
	
	
	public ProyectoBuilder(Articulo lider) {
		super();
		this.lider = lider;
		this.presupuesto = 0;
	}


	public Articulo getLider() {
		return lider;
	}


	public void setLider(Articulo lider) {
		this.lider = lider;
	}


	public double getPresupuesto() {
		return presupuesto;
	}


	public void setPresupuesto(double presupuesto) {
		this.presupuesto = presupuesto;
	}
	
	
	
	

}
