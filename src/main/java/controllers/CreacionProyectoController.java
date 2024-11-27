package controllers;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
       
    
    public CreacionProyectoController() {
    	
    	RepoFactory factory = new RepoFactory();
    	this.usuariosRepo =factory.getUsuarioRepo();
    	    
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		
		HttpSession session = request.getSession();
		
		
		Articulo articuloLogNullable = (Articulo) session.getAttribute("articulo");
		
		Articulo articuloLog = Optional.ofNullable(articuloLogNullable).orElseThrow(()-> new IOException("No hay articulo"));
		
		
		Articulo articuloActualizado = ArticuloRepo.findById(articuloLog.getCodigo());
		
		ProyectoBuilder proyecto = (ProyectoBuilder) session.getAttribute("proyecto");
		
		
		
		
		
 		
	//	proyecto = Optional.ofNullable(proyecto).orElse(new ProyectoBuilder(articuloLog));
		
		proyecto = Optional.ofNullable(proyecto).orElseGet(()->{
			ProyectoBuilder pro = new ProyectoBuilder(articuloActualizado);
			session.setAttribute("proyecto", pro);
			return pro;
		});
		
		
		session.setAttribute("proyecto", proyecto);
		
		request.setAttribute("proyecto", proyecto);
		
		
		request.getRequestDispatcher("/views/creacion-proyecto/index.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String accion = request.getParameter("accion");
		
		switch (accion) {
		case "modifpre"-> doModificarPresupuesto(request,response);
			
		default -> response.sendError(404);
		}
		
		

	}

	private Object doModificarPresupuesto(HttpServletRequest request, HttpServletResponse response) throws IOException {
				
		HttpSession session = request.getSession();
		ProyectoBuilder proyecto = (ProyectoBuilder) session.getAttribute("proyecto");
		

		Articulo articuloLogNullable = (Articulo) session.getAttribute("articulo");
		
		Articulo articuloLog = Optional.ofNullable(articuloLogNullable).orElseThrow(()-> new IOException("No hay articulo"));
		
			
		return proyecto = Optional.ofNullable(proyecto).orElseGet(()->{
			ProyectoBuilder pro = new ProyectoBuilder(articuloLog);
			session.setAttribute("proyecto", pro);
			return pro;
		});
		
		String sImporte = request.getParameter("importe");
		double importe = Double.parseDouble(sImporte);
		
		proyecto.setPresupuesto(serialVersionUID);
		
		
		response.sendRedirect("crear");
		
	}

}
