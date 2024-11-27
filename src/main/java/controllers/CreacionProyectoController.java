package controllers;

import java.io.IOException;
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
import factory.RepoFactory;
import modelos.Articulo;
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
					
					
					default -> response.sendError(404);
				}	
	
			}catch (ArticuloDeslogueadoException e) {
				response.sendRedirect("auth");
			}
			
		

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
