package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import factory.RepoFactory;
import modelos.Usuario;
import repositories.interfaces.UsuarioRepo;


@WebServlet("/AuthController")
public class AuthController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UsuarioRepo usuariosRepo;
       
    
    public AuthController() {
    	
    	RepoFactory factory = new RepoFactory();
    	this.usuariosRepo =factory.getUsuarioRepo();
    	    
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		List<Usuario> usuarios = usuariosRepo.getAll();
		
		request.setAttribute("usuarios",usuarios);
		
		request.getRequestDispatcher("/views/auth/login.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
