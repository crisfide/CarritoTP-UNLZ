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
import javax.sql.rowset.serial.SerialException;
import javax.websocket.Session;

import com.oracle.wls.shaded.org.apache.regexp.RE;

import factory.RepoFactory;
import modelos.Articulo;
import modelos.Registro;
import modelos.Usuario;
import repositories.ArticuloRepoSingleton;
import repositories.interfaces.ArticuloRepo;
import repositories.interfaces.RegistroRepo;

@WebServlet("/registro")
public class RegistroController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private RegistroRepo registrossRepo;
       
    public RegistroController() {       
    	   
       RepoFactory factory = new RepoFactory();
       this.registrossRepo = factory.getRegistroRepo();
    }
    
    //DO-GET

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Usuario u = (Usuario) session.getAttribute("usuario");	
		if( u ==null ) {
			response.sendError(401,"No autorizado");
			return;
		}
		
		String accion = request.getParameter("accion");
		accion = Optional.ofNullable(accion).orElse("index");
		
		switch (accion) {
			case "index" -> getIndex(request,response);
			case "show" -> getShow(request,response);
			
			default -> response.sendError(404);
		}
	}


	private void getShow(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String sId = request.getParameter("id");
		int id = Integer.parseInt(sId);
		
		Registro r = registrossRepo.findById(id);
		
		request.setAttribute("registro",r);
			
		
		request.getRequestDispatcher("/views/registro/show.jsp").forward(request, response);

	}

	private void getIndex(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Usuario u = (Usuario) session.getAttribute("usuario");	
		
		List<Registro> lista;
		
		if(u.getRol().equals("Empleado")) {
			lista = this.registrossRepo.getAll();
		}else {
			lista = this.registrossRepo.getAllUser(u);
		}
		
		request.setAttribute("lista", lista);
		
		
		
		request.getRequestDispatcher("/views/registro/index.jsp").forward(request, response);

	}
	
	
	//DO-POST
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		
		
	}
	
	


}



















