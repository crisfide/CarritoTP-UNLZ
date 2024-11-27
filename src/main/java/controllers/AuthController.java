package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import decorators.SessionDecorator;
import factory.RepoFactory;
import modelos.Usuario;
import repositories.interfaces.UsuarioRepo;


@WebServlet("/auth")
public class AuthController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UsuarioRepo usuariosRepo;
       
    
    public AuthController() {
    	
    	RepoFactory factory = new RepoFactory();
    	this.usuariosRepo =factory.getUsuarioRepo();
    	    
    }

	//DO-GET
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//List<Usuario> usuarios = usuariosRepo.getAll();
		
		//request.setAttribute("usuarios",usuarios);
		
		request.getRequestDispatcher("/views/auth/login.jsp").forward(request, response);
	}

	//DO-POST
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nombre = request.getParameter("usuario");
		String contraseña = request.getParameter("contraseña");
		
		Usuario usu = usuariosRepo.findByNombre(nombre);
		
		if(usu != null && usu.getContraseña().equals(contraseña)) {
			
			HttpSession session = request.getSession();
			
			SessionDecorator sessionDe = new SessionDecorator(session);
			
			//sessionDe.setArticuloLogueado(usu);
			
			session.setAttribute("usuario", usu);
			
			if(usu.getRol().equals("Empleado")) {
				
			response.sendRedirect("articulo");
			
			} else {
				
			response.sendRedirect("carrito");
			}
				
			
		} else {
			
			request.setAttribute("error","Verifique Usuario y Contraseña");
			request.getRequestDispatcher("/views/auth/login.jsp").forward(request, response);
		}
		
		
		
	}
	
	

}
