package controllers;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.oracle.wls.shaded.org.apache.bcel.generic.RET;
import com.oracle.wls.shaded.org.apache.regexp.recompile;

import decorators.SessionDecorator;
import exeptions.ArticuloDeslogueadoException;
import exeptions.PresupuestoExcedidoException;
import factory.RepoFactory;
import modelos.Articulo;
import modelos.Proyecto;
import modelos.ProyectoDetalle;
import repositories.interfaces.ArticuloRepo;
import repositories.interfaces.UsuarioRepo;
import utils.ProyectoBuilder;

/**
 * Servlet implementation class CreacionProyectoController
 */
@WebServlet("/CreacionProyectoController")
public class CreacionProyectoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	private UsuarioRepo usuariosRepo;


	private ArticuloRepo articulosRepo;
       
    
    public CreacionProyectoController() {
    	
    	RepoFactory factory = new RepoFactory();
    	this.usuariosRepo =factory.getUsuarioRepo();
    	    
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		HttpSession session = request.getSession();
		
		SessionDecorator sessionDec = new SessionDecorator(session); 
		
		
		Articulo articuloActualizado ;
	try {
		
		Articulo articuloActualizado1 = sessionDec.getArticuloLogueadoActu(articulosRepo);
		
		
	
		
		ProyectoBuilder proyecto = sessionDec.getProyecto();
		
	//	proyecto.setLider(articuloActualizado);
		
		
	//	session.setAttribute("proyecto", proyecto);
		
		List<Articulo> articulos =articulosRepo.getAll();
		
		request.setAttribute("proyecto", proyecto);
		request.setAttribute("logueado", articuloActualizado1);
		request.setAttribute("articulos", articulos);
		
		request.getRequestDispatcher("/views/creacion-proyecto/index.jsp").forward(request, response);
		
	} catch (ArticuloDeslogueadoException e) {
			response.sendRedirect("auth");
			return;
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	
			String accion = request.getParameter("accion");
		
			try {
				switch (accion) {
					case "modifpre"-> postModificarPresupuesto(request,response);
					case "agegarart"-> postAgregarArticulo(request,response);
					case "finalizar"-> postFinalizar(request,response);
					
					default -> response.sendError(404);
				}	
	
			}catch (ArticuloDeslogueadoException e) {
				response.sendRedirect("auth");
			} catch (PresupuestoExcedidoException e) {
				response.sendError(400,e.getMessage());
			}
			
		

	}

	private void postFinalizar(HttpServletRequest request, HttpServletResponse response) throws ArticuloDeslogueadoException, PresupuestoExcedidoException, IOException  {
		
		SessionDecorator sDec = new SessionDecorator(request.getSession());
		
		Articulo lider = sDec.getArticuloLogueadoActu(articulosRepo);
		
		ProyectoBuilder proBuilder = sDec.getProyecto();
		
		Proyecto pro = proBuilder.toProyecto(articulosRepo, lider.getCodigo());
		
		sDec.removeProyecyo();
		
		
		var w = response.getWriter();
		
		w.append(pro.toString()).append("\n");
		for (ProyectoDetalle detalle : pro.getDetalle()) {
			w.append(detalle.toString()).append("\n");
			
		}
		
		//Guardar bdd
		
	}


	private void postAgregarArticulo(HttpServletRequest request, HttpServletResponse response) throws IOException  {

		String sArticuloCod = request.getParameter("articulo");
		int articuloCod = Integer.parseInt(sArticuloCod);
		String tarea = request.getParameter("tarea");
		
		SessionDecorator sDec = new SessionDecorator(request.getSession());
		
		ProyectoBuilder proyecto = sDec.getProyecto();
		
		Articulo arti = articulosRepo.findById(articuloCod);
		
		proyecto.agregarTupla(arti, tarea);
		
		response.sendRedirect("crear");
		
	}


	private void postModificarPresupuesto(HttpServletRequest request, HttpServletResponse response) throws IOException, ArticuloDeslogueadoException {
				
		HttpSession session = request.getSession();
		
		SessionDecorator sessionDec = new SessionDecorator(session); 
		
		ProyectoBuilder proyecto = sessionDec.getProyecto();
				
		String sImporte = request.getParameter("importe");
		
		double importe = Double.parseDouble(sImporte);
		
		proyecto.setPresupuesto(serialVersionUID);
		
		response.sendRedirect("crear");
		//return importe;
		
	}

}
