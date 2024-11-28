package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import exeptions.PresupuestoExcedidoException;
import modelos.Articulo;
import modelos.Proyecto;
import modelos.ProyectoDetalle;
import repositories.interfaces.ArticuloRepo;

public class ProyectoBuilder {
	
	
	public class Tupla{
		private Articulo articulo;
		private String tarea;
		
		public double getPrecio() {
			return Optional.ofNullable(articulo).map(Articulo::getPrecio).orElse(0.0);
		}
		
	
		public Tupla(Articulo arti, String tarea) {
			super();
			this.articulo = arti;
			this.tarea = tarea;
			
		}
		public Articulo getArticulo() {
			return articulo;
		}
		public void setArticulo(Articulo arti) {
			this.articulo = arti;
		}
		public String getTarea() {
			return tarea;
		}
		public void setTarea(String tarea) {
			this.tarea = tarea;
		}
		
		
		
	}
	
	
	
	//private Articulo lider;
	private double presupuesto;
	private List<ProyectoBuilder.Tupla> tuplas;
	
	
	public double getTotal() {
		double total = this.tuplas.stream()
				.mapToDouble(Tupla::getPrecio)
				.sum();
		
		return total;
	}
	
	
	
	public ProyectoBuilder() {
	//	super();
	//	this.lider = lider;
		this.presupuesto = 0;
		this.tuplas= new ArrayList<ProyectoBuilder.Tupla>();
	}


	public void agregarTupla(Articulo arti, String tarea) {
		this.tuplas.add(new ProyectoBuilder.Tupla(arti, tarea));
	}
	
	



	public List<ProyectoBuilder.Tupla> getTuplas() {
		return tuplas;
	}


	public double getPresupuesto() {
		return presupuesto;
	}


	public void setPresupuesto(double presupuesto) {
		this.presupuesto = presupuesto;
	}
	
	
	
	public Proyecto toProyecto(ArticuloRepo aRepo,  int liderCodigo) throws PresupuestoExcedidoException {
		
		
		
		Proyecto proyecto= new Proyecto(liderCodigo, this.presupuesto, this.getTotal());
				
		for (Tupla tupla : tuplas) {
			
			
			Articulo arti = aRepo.findById(tupla.getArticulo().getCodigo());
			
			tupla.setArticulo(arti);
			
			proyecto.addDetalle(arti.getCodigo(), tupla.tarea, arti.getPrecio());
			
			
			
		}
		
		
		if( this.presupuesto < this.getTotal()) {
			throw new PresupuestoExcedidoException("Se ha superado el presupuesto");
			
		}
		
		
		return proyecto;
	}
	
	

}
